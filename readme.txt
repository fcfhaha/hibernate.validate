

注意:

国际化: 

	注意: ** 加  <property name="defaultEncoding" value="UTF-8"/>
		 ** properties文件的编码不能是UTF-8 ,如果是UTF-8 的话, 可能会出现中文乱码
		 


***********************************************
1.Bean Validation 中内置的可以用的 constraint 如下：

注解 					作用
@Valid 	被注释的元素是一个对象，需要检查此对象的所有字段值
@Null 	被注释的元素必须为 null
@NotNull 	被注释的任何元素必须不为 null
@AssertTrue 	被注释的元素必须为 true
@AssertFalse 	被注释的元素必须为 false
@Min(value) 	被注释的元素必须是一个数字，其值必须大于等于指定的最小值
@Max(value) 	被注释的元素必须是一个数字，其值必须小于等于指定的最大值
@DecimalMin(value) 	被注释的元素必须是一个数字，其值必须大于等于指定的最小值
@DecimalMax(value) 	被注释的元素必须是一个数字，其值必须小于等于指定的最大值
@Negative 	被注释的元素必须是一个负数
@NegativeOrZero 	被注释的元素必须是负数或 0
@Positive 	被注释的元素必须是一个正数
@PositiveOrZero 	被注释的元素必须是一个正数或 0
@Size(max, min) 	被注释的元素的大小必须在指定的范围内
@Digits (integer, fraction) 	被注释的元素必须是一个数字，其值必须在可接受的范围内
@Past 	被注释的元素必须是一个过去的日期
@PastOrPresent 	被注释的元素必须是一个过去或当前的日期
@Future 	被注释的元素必须是一个将来的日期
@FutureOrPresent 	被注释的元素必须是一个将来或当前的日期
@Pattern(value) 	被注释的元素必须符合指定的正则表达式
@NotEmpty 	集合对象的元素不为0，即集合不为空，也可以用于字符串不为 null
@NotBlank 	只能用于字符串不为null，并且字符串trim()以后length要大于0
@Email 	被注释的元素必须是一个有效的邮箱地址


*********************************************************
2.Hibernate Validator 完全遵循了 Bean Validation 的规范，并在其基础上有附加的扩展。

注解 													作用

@CreditCardNumber(ignoreNonDigitCharacters=) 	被注释的字符串必须通过 Luhn 校验算法，银行卡，信用卡等号码一般都用 Luhn 计算合法性
@Currency(value=) 	被注释的 javax.money.MonetaryAmount 货币元素是否合规
@DurationMax(days=, hours=, minutes=, seconds=, millis=, nanos=, inclusive=) 	被注释的元素不能大于指定日期
@DurationMin(days=, hours=, minutes=, seconds=, millis=, nanos=, inclusive=) 	被注释的元素不能低于指定日期
@EAN 	被注释的元素是否是一个有效的 EAN 条形码
@Length(min=, max=) 	被注释的字符串的大小必须在指定的范围内
@LuhnCheck(startIndex= , endIndex=, checkDigitIndex=, ignoreNonDigitCharacters=) 	Luhn 算法校验字符串中指定的部分
@Mod10Check(multiplier=, weight=, startIndex=, endIndex=, checkDigitIndex=, ignoreNonDigitCharacters=) 	Mod10 算法校验
@Mod11Check(threshold=, startIndex=, endIndex=, checkDigitIndex=, ignoreNonDigitCharacters=, treatCheck10As=, treatCheck11As=) 	Mod11 算法校验
@Range(min=, max=) 	被注释的元素必须在合适的范围内
@SafeHtml(whitelistType= , additionalTags=, additionalTagsWithAttributes=, baseURI=) 	classpath中要有jsoup包
@ScriptAssert(lang=, script=, alias=, reportOn=) 	检查脚本是否可运行
@URL(protocol=, host=, port=, regexp=, flags=) 	被注释的字符串必须是一个有效的url


