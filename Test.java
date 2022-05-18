package javatest;

//三种方式获取class对象
/*
1.使用class属性来获取class对象
2.使用getClass方法来获取class对象
3.使用Class中的静态成员方法forName(String className):通过类的全路径来获取class对象
 */

//class student{
//    public String name;
//    public int age;
//
//    public student() {
//    }
//
//    public student(String name, int age) {
//        this.name = name;
//        this.age = age;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getAge() {
//        return age;
//    }
//
//    public void setAge(int age) {
//        this.age = age;
//    }
//}
//public class Test {
//    public static void main(String[] args) throws ClassNotFoundException {
//        //1.使用class属性来获取class对象
//        Class<student> c1 = student.class;
//        System.out.println(c1);//class javatest.student 这个类在javatest包下
//        //2.使用getClass方法来获取class对象
//        student s=new student();
//        Class<? extends student> c2 = s.getClass();
//        System.out.println(c1==c2);//true
//        //3.使用Class中的静态成员方法forName(String className):通过类的全路径来获取class对象
//        Class<?> c3 = Class.forName("javatest.student");
//        System.out.println(c2==c3);//true 说明他们获取的是同一个class对象
//    }
//}

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

//反射获取构造方法并使用练习
//class student{
//    public String name;
//    public int age;
//    public String addr;
//
//    public student() {
//    }
//
//    public student(String name, int age, String addr) {
//        this.name = name;
//        this.age = age;
//        this.addr = addr;
//    }
//    //如果要直接打印的话要重写toString方法
//    @Override
//    public String toString() {
//        return "student{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                ", addr='" + addr + '\'' +
//                '}';
//    }
//}
//
//public class Test {
//    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        Class<?> c1 = Class.forName("javatest.student");
//        Constructor<?> con = c1.getConstructor(String.class, int.class, String.class);//获取对象的构造方法
//        Object obj = con.newInstance("林青霞", 30, "西安");//构造方法通过反射获取构造对象
//        System.out.println(obj);//student{name='林青霞', age=30, addr='西安'}//
//        当然获取构造方法的方式有很多 这里就不列举出来了 感兴趣的话自己取了解
//
//    }
//}



//class student{
//    public String name;
//    public int age;
//    public String addr;
//
//    public student() {
//    }
//
//    public student(String name, int age, String addr) {
//        this.name = name;
//        this.age = age;
//        this.addr = addr;
//    }
//    private student(String name){//私有构造方法
//        this.name=name;
//    }
//    //如果要直接打印的话要重写toString方法
//    @Override
//    public String toString() {
//        return "student{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                ", addr='" + addr + '\'' +
//                '}';
//    }
//}
//
//public class Test {
//    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        Class<?> c1 = Class.forName("javatest.student");
//        Constructor<?> con1 = c1.getDeclaredConstructor(String.class);//如果要获取的构造方法是私有的 就要用getDeclaredConstructor(可以获取所有构造方法)
//        //void	setAccessible(boolean flag)将此反射对象的标志设置为指示的布尔值。
//        con1.setAccessible(true);//flag为true 取消访问检查  如果没有这句  则不嫩通过获取的私有构造函数创建对象
//        Object obj = con1.newInstance("林青霞");
//        System.out.println(obj);//student{name='林青霞', age=0, addr='null'}
//
//    }
//}

//反射获取成员变量并使用
/*
Field	getField(String name)返回一个对象，该对象反映此对象所表示的类或接口的指定公共成员字段。FieldClass
Field[]	getFields()返回一个数组，其中包含反映此对象所表示的类或接口的所有可访问公共字段的对象。FieldClass
Field	getDeclaredField(String name)返回一个对象，该对象反映此对象所表示的类或接口的指定声明字段。FieldClass
Field[]	getDeclaredFields()返回一个对象数组，该数组反映此对象所表示的类或接口所声明的所有字段。FieldClass

Filed类中给成员变量赋值的方法
void set(Object obj,Object value):给obj对象的成员变量赋值为 Value
 */


//class student{
//    public String name;
//    public int age;
//    public String addr;
//
//    public student() {
//    }
//
//    public student(String name, int age, String addr) {
//        this.name = name;
//        this.age = age;
//        this.addr = addr;
//    }
//    //如果要直接打印的话要重写toString方法
//    @Override
//    public String toString() {
//        return "student{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                ", addr='" + addr + '\'' +
//                '}';
//    }
//}
//
//
//public class Test {
//    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//      Class<?> c = Class.forName("javatest.student");
////        c.getField()
//        Field[] file = c.getDeclaredFields();
//        for(Field f:file){
//            System.out.println(f);
//            /*
//            public java.lang.String javatest.student.name
//            public int javatest.student.age
//            public java.lang.String javatest.student.addr
//             */
//        }
//
// //       Field f = c.getField("addr");
//        //获取无参构造方法创建对象
////        Constructor<?> con = c.getConstructor();
////        Object obj = con.newInstance();
////        //给con对象中的元素赋值
////        f.set(obj,"西安");
////        System.out.println(obj);//student{name='null', age=0, addr='西安'}
////
//
//        Field f = c.getField("name");
//        Constructor<?> con = c.getConstructor();
//        Object obj = con.newInstance();
//        //给con对象中的元素赋值
//        f.set(obj,"张三");
//        System.out.println(obj);//student{name='张三', age=0, addr='null'}
//
//
//    }
//}


//通过反射获取成员变量并使用


//class student{
//    private String name;
//    private int age;
//    public String addr;
//
//    public student() {
//    }
//
//    public student(String name, int age, String addr) {
//        this.name = name;
//        this.age = age;
//        this.addr = addr;
//    }
//    //如果要直接打印的话要重写toString方法
//    @Override
//    public String toString() {
//        return "student{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                ", addr='" + addr + '\'' +
//                '}';
//    }
//}
//public class Test {
//    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        Class<?> c = Class.forName("javatest.student");
//        //Field f = c.getField("name");//此时name是私有的成员变量 系统将报报没有此对象
//        Field f = c.getDeclaredField("name");
//        f.setAccessible(true);//如果没有也不行 跳过访问检查
//        Constructor<?> con = c.getConstructor();
//        Object obj = con.newInstance();
//        f.set(obj,"张三");
//        System.out.println(obj);//student{name='张三', age=0, addr='null'}
//
//        Field age = c.getDeclaredField("age");
//        age.setAccessible(true);//如果没有也不行 跳过访问检查
//        age.set(obj,10);
//        System.out.println(obj);//student{name='张三', age=10, addr='null'}
//
//        Field addr = c.getDeclaredField("addr");
//        addr.setAccessible(true);//如果没有也不行 跳过访问检查
//        addr.set(obj,"西安");
//        System.out.println(obj);//student{name='张三', age=10, addr='西安'}、
//        //即便成员变量为public属性 也可以使用getDeclaredField来获取成员变量 并且跳过访问检查
//    }
//}


//反射获取成员方法并使用
/*
Class类中用于获取成员方法的方法
Methodl]getMethods(:返回所有公共成员方法对象的数组，包括继承的
Methodl]getDeclaredMethods(:返回所有成员方法对象的数组，不包括继承的
Method getMethod(String name, Class<?>... parameterTypes):返回单个公共成员方法对象
Method getDeclaredMethod(String name, Class<?>... parameterTypes):返回单个成员方法对象

Method类中用于调用成员方法的方法
.object invoke(Objectobj, Object..args):调用obj对象的成员方法，参数是args,返回值是Object类型
 */
//class student{
//    private String name;
//    private int age;
//    public String addr;
//
//    public student() {
//    }
//    public void method1(){
//        System.out.println("print method1");
//    }
//    public student(String name, int age, String addr) {
//        this.name = name;
//        this.age = age;
//        this.addr = addr;
//    }
//    //如果要直接打印的话要重写toString方法
//    @Override
//    public String toString() {
//        return "student{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                ", addr='" + addr + '\'' +
//                '}';
//    }
//}
//public class Test {
//    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        Class<?> c = Class.forName("javatest.student");
//        Method[] methods = c.getMethods();
//        for(Method m:methods){
//            System.out.println(m);
//            /*
//            public java.lang.String javatest.student.toString()
//            public void javatest.student.methon1()
//            public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
//            public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
//            public final void java.lang.Object.wait() throws java.lang.InterruptedException
//            public boolean java.lang.Object.equals(java.lang.Object)
//            public native int java.lang.Object.hashCode()
//            public final native java.lang.Class java.lang.Object.getClass()
//            public final native void java.lang.Object.notify()
//            public final native void java.lang.Object.notifyAll()
//            输出了包括自己定义的方法和继承自父类的方法
//             */
//        }
//        Method method1 = c.getMethod("method1");
//        Constructor<?> con = c.getConstructor();
//        Object obj = con.newInstance();
//        method1.invoke(obj);//print method1  函数调用成功
//    }
//}

//反射获取成员方法并使用练习

//class student{
//    private String name;
//    private int age;
//    public String addr;
//
//    public student() {
//    }
//    public void method1(){
//        System.out.println("print method1");
//    }
//    public void method2(String s){
//        System.out.println(s);
//    }
//    private void method3(String s,int i){
//        System.out.println(s+","+i);
//    }
//    public String method4(String s){
//        return s;
//    }
//    public student(String name, int age, String addr) {
//        this.name = name;
//        this.age = age;
//        this.addr = addr;
//    }
//    //如果要直接打印的话要重写toString方法
//    @Override
//    public String toString() {
//        return "student{" +
//                "name='" + name + '\'' +
//                ", age=" + age +
//                ", addr='" + addr + '\'' +
//                '}';
//    }
//}
//public class Test {
//    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
//        Class<?> c = Class.forName("javatest.student");
//        Method[] methods = c.getMethods();
//        for(Method m:methods){
//            System.out.println(m);
//            /*
//            public java.lang.String javatest.student.toString()
//            public void javatest.student.methon1()
//            public final native void java.lang.Object.wait(long) throws java.lang.InterruptedException
//            public final void java.lang.Object.wait(long,int) throws java.lang.InterruptedException
//            public final void java.lang.Object.wait() throws java.lang.InterruptedException
//            public boolean java.lang.Object.equals(java.lang.Object)
//            public native int java.lang.Object.hashCode()
//            public final native java.lang.Class java.lang.Object.getClass()
//            public final native void java.lang.Object.notify()
//            public final native void java.lang.Object.notifyAll()
//            输出了包括自己定义的方法和继承自父类的方法
//             */
//        }
//        Method method1 = c.getMethod("method1");
//        Constructor<?> con = c.getConstructor();
//        Object obj = con.newInstance();
//        method1.invoke(obj);//print method1  函数调用成功
//    }
//}





/*
整数拓展：
进制：
二进制：0b
十进制:没有标记
八进制：0
十六进制：0x
 */
//public class Test {
//    public static void main(String[] args) {
//        int a=0b10;
//        int b=10;
//        int c=010;
//        int d=0x10;
//        System.out.println(a);//2
//        System.out.println(b);//10  c和c++同样适用
//        System.out.println(c);//8
//        System.out.println(d);//16
//
//    }
//}



//javaDoc生成文档 先敲/** 回车
/*
javaDoc命令是用来生成自己的API文档的
参数信息：
@author 作者名
@version 版本号
@since 指明需要最早使用的jdk版本
@param 参数名
@x


 */
/**
 * @author kuangshen
 * @version 1.0
 * @since 1.8
 *
 */

//public class Test {
//        String name;
//
//    /**
//     *
//     * @param name
//     * @return
//     */
//        public String func(String name) {
//            return name;
//        }
//}



//java小算法
//public class Test {
//    public static void main(String[] args) {
//        Scanner sc=new Scanner(System.in);
//        double sum=0d;
//        int m=0;
//        while(sc.hasNextDouble()){//只要接收的数字是一个整形或浮点型就循环 否则退出
//            double x=sc.nextDouble();
//            sum+=x;
//            m++;
//        }
//        System.out.println("数字总和为:"+sum);
//        System.out.println("平均值为："+sum/m);
//    }
//}


//用for循环打印一个五行的三角形
//public class Test {
//    public static void main(String[] args) {
//        for (int i = 0; i < 5; i++) {
//            for(int j=5;j>i;j--){
//                System.out.print(" ");
//            }
//            for(int j=0;j<=i;j++){
//                System.out.print("*");
//            }
//
//            for(int j=0;j<i;j++){//j不能等于i  控制右半边比左半边少一
//                System.out.print("*");//
//            }
//            System.out.println();
//        }
//    }
//}


//稀疏数组的建立和还原 如果一个比较大的数组中存放了很多相同的元素（比如0）
// 那么我们可以采用稀疏数组来储存  并且我们还可以通过稀疏数组来还原原数组
//如果忘记 移步blibli up主：遇见狂神说 狂神说java p59 稀疏数组（偷懒~o~）


/*
面向对象编程：object-oriented programing (oop) 其中：oriented:以....为方向的 面对 朝向
面向对象编程的本质：以类的方式组织代码 ，以对象的放方式封装数据
 */

//自定义异常
//虽然用的不多  但是还是可以了解
//class MyException extends Exception{
//    private int x;
//
//    public MyException(int x) {
//        this.x = x;
//    }
//
//    @Override
//    public String toString() {//自己定义打印的错误信息
//        return "MyException{" +
//                "x=" + x +
//                '}';
//    }
//}
//public class Test {
//
//    public static void main(String[] args) throws MyException {
//        int x=11;
//        if(x>10){//如果x大于10：Exception in thread "main" MyException{x=11}
//            throw new MyException(x);//throw和throws的区别 throw是主动抛出异常 throws是在方法首部抛出异常
//        }
//        System.out.println("OK");
//    }
//}


//好了 javaSE学的差不多了  接下来该是数据库了
//-----------------------------------------














