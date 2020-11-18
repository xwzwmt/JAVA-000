package Week_05.First_class.JavaProxy;

public class Verify {
    // 使用jdk自带的proxy实现简单的AOP
    public static void main(String[] args) {
        // 设置系统参数，输出动态生成的代理类
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");

        Agency agency = new Agency();
        Bird bird = new Bird();

        // 绑定被代理对象，返回代理对象
        Object proxy = agency.bind(bird);
        EggLayable eggLayable = (EggLayable) proxy;
        eggLayable.Egg();

        Flyable flyable = (Flyable) proxy;
        flyable.fly();
    }
}
