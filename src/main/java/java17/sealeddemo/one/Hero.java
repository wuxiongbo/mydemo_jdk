package java17.sealeddemo.one;

/**
 * <p>TODO</p>
 *
 * @author wuxiongbo
 * @date 2022/7/5 19:25
 */

public sealed class Hero permits TankHero, AttackHero, SupportHero {
    public void function(){
        System.out.println("11111111111111");
    }
}
