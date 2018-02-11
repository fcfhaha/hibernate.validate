package com.hibernate.validate;

import java.util.Date;
import org.junit.Assert;
import org.junit.Test;
import com.hibernate.validator.ValidationResult;
import com.hibernate.validator.ValidationUtils;
import com.hibernate.validator.group.CarGroup;
import com.hibernate.validator.vo.Car;
import com.hibernate.validator.vo.PassWordTestEntity;
import com.hibernate.validator.vo.SimpleEntity;

public class ValidationUtilsTest {

	@Test
	public void validateSimpleEntity() {
		SimpleEntity se = new SimpleEntity();
		se.setDate(new Date());
		se.setEmail("123");
		se.setName("123");
		se.setPassword("123");
		se.setValid(false);
		ValidationResult result = ValidationUtils.validateEntity(se);
		System.out.println("--------------------------");
		System.out.println(result);
		Assert.assertTrue(result.isHasErrors());

	}

	@Test
	public void validateSimpleProperty() {
		SimpleEntity se = new SimpleEntity();
		ValidationResult result = ValidationUtils.validateProperty(se, "name");
		System.out.println("--------------------------");
		System.out.println(result);
		Assert.assertTrue(result.isHasErrors());
	}

	@Test
	public void validateExtendEntity() {
		PassWordTestEntity ee = new PassWordTestEntity();
		ee.setPassword("212");
		ValidationResult result = ValidationUtils.validateEntity(ee);
		System.out.println("--------------------------");
		System.out.println(result);
		Assert.assertTrue(result.isHasErrors());
	}

	@Test
	public void validateIsEmail() {
		Car car = new Car("dd-ccc", "DD-AB-123", 4, "fcf");

		ValidationResult result = ValidationUtils.validateEntity(car);
		System.out.println("--------------------------");
		System.out.println(result);
		Assert.assertTrue(result.isHasErrors());

	}

	@Test
	public void validateGroup() {
		// 校验带Default.class的注解, 没有分组的默认是Default.class组
		Car car1 = new Car(null, "DD-AB-123", 4, "fcf");
		ValidationResult result = ValidationUtils.validateEntity(car1);// use Default.class group
		System.out.println(result);
		Assert.assertTrue(result.isHasErrors());
		System.out.println("--------------------------");

		// 只是校验带了CarGroup.class的注解
		Car car2 = new Car(null, "DD-AB-123", 4, "fcf");
		ValidationResult result2 = ValidationUtils.validateEntity(car2, CarGroup.class);// use CarGroup.class group
		System.out.println(result2);
		Assert.assertTrue(result2.isHasErrors());

	}
}
