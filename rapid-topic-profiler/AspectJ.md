# 在Spring AOP中目前只有执行方法这一个连接点，Spring AOP支持的AspectJ切入点指示符如下：
[from](http://sishuok.com/forum/posts/list/281.html) here!
 
```
	execution：用于匹配方法执行的连接点。execution(* com.rapid.example.topic.profiler.integration..*.*(..));
	within：用于匹配指定类型内的方法执行；
	this：用于匹配当前AOP代理对象类型的执行方法；注意是AOP代理对象的类型匹配，这样就可能包括引入接口也类型匹配；
	target：用于匹配当前目标对象类型的执行方法；注意是目标对象的类型匹配，这样就不包括引入接口也类型匹配；
	args：用于匹配当前执行的方法传入的参数为指定类型的执行方法；
	@within：用于匹配所以持有指定注解类型内的方法；
	@target：用于匹配当前目标对象类型的执行方法，其中目标对象持有指定的注解；
	@args：用于匹配当前执行的方法传入的参数持有指定注解的执行；
	@annotation：用于匹配当前执行方法持有指定注解的方法；
 	bean：Spring AOP扩展的，AspectJ没有对于指示符，用于匹配特定名称的Bean对象的执行方法；
	reference pointcut：表示引用其他命名切入点，只有@ApectJ风格支持，Schema风格不支持。
```
         
## 类型匹配语法
```
* 匹配任何数量字符；
.. 匹配任何数量字符的重复，如在类型模式中匹配任何数量子包；而在方法参数模式中匹配任何数量参数。
+ 匹配指定类型的子类型；仅能作为后缀放在类型模式后边

如
java.lang.String   匹配String类型;
java.*.String      匹配java包下的任何“一级子包”下的String类型; 如匹配java.lang.String,但不匹配java.lang.ss.String;
java..*            匹配java包及任何子包下的任何类型;如匹配java.lang.String、java.lang.annotation.Annotation
java.lang.*ing     匹配任何java.lang包下的以ing结尾的类型;
java.lang.Number+  匹配java.lang包下的任何Number的自类型;如匹配java.lang.Integer，也匹配java.math.BigInteger
```

## 切入点使用示例
### execution
> 使用“execution(方法表达式)”匹配方法执行

`public * *(..)` 任何公共方法的执行

`* cn.javass..IPointcutService.*()` cn.javass包及所有子包下IPointcutService接口中的任何无参方法

AccountService 接口的任意方法的执行：
execution(* com.xyz.service.AccountService.*(..))

定义在service包里的任意方法的执行：
execution(* com.xyz.service.*.*(..))

定义在service包和所有子包里的任意类的任意方法的执行：
execution(* com.xyz.service..*.*(..))
 
| a | b |
| ---- |:-----:| ----:|
| a | f |