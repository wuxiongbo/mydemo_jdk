package java17.sealeddemo.one;

/**
 * <p>TODO</p>
 *
 * 父类Hero被sealed修饰之后，sealed的密封要求被传递过来，
 * 此时子类就必须在sealed、non-sealed、final之间选择一个定义，它们分别代表：
 *
 * sealed：继续延续密封类特性，可以继续指定继承的类，并传递密封定义给子类
 * non-sealed：声明这个类为非密封类，可以被任意继承
 * final：不允许继承
 *
 *
 * @author wuxiongbo
 * @date 2022/7/5 19:25
 */
public sealed class AttackHero
        extends Hero
        permits Ezreal {

}
