package Config;

/**
 * Created by qiumin on 2015/8/18.
 */
public class Calculator_cfg extends module_config{
    public Calculator_cfg(){
        super();
    }

    @Override
    public void set_default() {
        this.name="Calculator";
        this.pkg="calculator2";
        add("history_clear" ,new button(".+history_clear_land",method_sel.id,"清除历史记录按钮"));
        add("slide_drawer"  ,new button(".+slidingDrawerView",method_sel.id,"点击历史记录会滑下来覆盖计算器界面"));
        add("expression"    ,new button("s5)*2="       ,method_sel.text,"测试计算器时，输入的表达式，具体符号意思详见Calculator模块")) ;
        add("real_result"   ,new button("-1.9178485"   ,method_sel.text,"测试计算器时，用来比对的结果")) ;
        add("cal_result"    ,new button(""             ,method_sel.text,"计算器的计算结果，显示在TextEditer中"));
        add("clear"         ,new button("C",method_sel.text,"清除输入按钮，就是那个C"));
        add("equal"         ,new button("=",method_sel.text,"等号"));
        add("plus"          ,new button("+",method_sel.text,"加号"));
        add("minus"         ,new button("−",method_sel.text,"减号"));
        add("multiply"      ,new button("×",method_sel.text,"乘号"));
        add("division"      ,new button("÷",method_sel.text,"除号"));
        add("del"           ,new button(".+del",method_sel.id,"删除输入键"));
        add("dot"           ,new button(".",method_sel.text,"小数点"));
        add("sin"           ,new button("sin",method_sel.text,"sin"));
        add("cosin"         ,new button("cos",method_sel.text,"cosin"));
        add("tan"           ,new button("tan",method_sel.text,"tan"));
        add("ln"            ,new button("ln",method_sel.text,"ln"));
        add("log"           ,new button("log",method_sel.text,"log"));
        add("factorial"     ,new button("!",method_sel.text,"阶乘"));
        add("pi"            ,new button("π",method_sel.text,"圆周率"));
        add("e"             ,new button("e",method_sel.text,"自然数e"));
        add("power"         ,new button("^",method_sel.text,"乘方"));
        add("left_paren"    ,new button("(",method_sel.text,"左圆括号"));
        add("left_paren"    ,new button(")",method_sel.text,"右圆括号"));
        add("sqrt"          ,new button("√",method_sel.text,"开方"));
        add("percent"       ,new button("%",method_sel.text,"百分比"));
        add("divd"          ,new button("1/X",method_sel.text,"分之一"));
        add("square"        ,new button("X^2",method_sel.text,"平方"));
        add("result"        ,new button("",method_sel.text,"结果栏"));
        add("zero"          ,new button("0",method_sel.text,"0"));
        add("one"           ,new button("1",method_sel.text,"1"));
        add("two"           ,new button("2",method_sel.text,"2"));
        add("three"         ,new button("3",method_sel.text,"3"));
        add("four"          ,new button("4",method_sel.text,"4"));
        add("five"          ,new button("5",method_sel.text,"5"));
        add("six"           ,new button("6",method_sel.text,"6"));
        add("seven"         ,new button("7",method_sel.text,"7"));
        add("eight"         ,new button("8",method_sel.text,"8"));
        add("nine"          ,new button("9",method_sel.text,"9"));
    }

}
