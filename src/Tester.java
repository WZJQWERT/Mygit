import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;


public class Tester {
   /*

   14.6根据分词结果求值

    */


    public static void main(String[] args) {
        //声明表达式的表达式内容
        String expression = " 12+ 2 + 9 -10 / 54  43+32+32.5   ";
        Queue<String> words = split(expression);
        double result = calc(words);
        System.out.println(result);
    }

    //计算数和运算符序列的值
    private static double calc(Queue<String> words) {
            /*
            1: 遇到数就存储
            2：遇到运算符
            2.0 当运算符栈中之前没有运算符时，则储存运算符
            2.1 当运算符优先级与之前运算符相等，则计算之前的运算符
            2.2 当运算符优先级大于之前运算符，则储存之前的运算符
            2.3 当运算符优先级小于之前运算符，则计算之前的运算符
             */
        Stack<Double> numbers = new Stack<>();
        Stack<String> operators = new Stack<>();
        for (String word : words) {

        try {
            numbers.push(Double.parseDouble(word));
        } catch (Exception e) {
            while (!operators.isEmpty() && getLevel(word) <= getLevel(operators.peek())) {
                calc(numbers, operators);
            }
            operators.push(word);
        }
    }
            while(!operators.isEmpty()){
            calc(numbers, operators);
    }
                return numbers.pop();
    }
    private static void calc(Stack <Double> numbers,Stack<String>operators) {
        //2.1 && 2.3
        String operator = operators.pop();
        Double number0 = numbers.pop();
        Double number1 = numbers.pop();
        switch (operator) {
            case "+":
                numbers.push(number1 + number0);
                break;
            case "-":
                numbers.push(number1 + number0);
                break;
            case "*":
                numbers.push(number1 + number0);
                break;
            case "/":
                numbers.push(number1 + number0);
                break;
            default:
                throw new IllegalArgumentException();
        }
    }
    //返回运算符的优先级
    private static int getLevel(String operator) {
        switch (operator) {
            case "+":
            case "-":
                return 1;
            case "*":
            case "/":
                return 2;
            default:
                throw new IllegalArgumentException();
        }
    }
    //将参数字符串(四则运算表达式)分解成独立的词（数或者运算符）
    private static Queue<String>split(String expression){
    LinkedList<String>words =new LinkedList<>();
        Integer state = 0;
        StringBuilder buffer = new StringBuilder();
        LinkedList<Character>chars =new LinkedList<>();
        for(char c :expression.toCharArray()) {
        chars.add(c);
    }
            HashMap <Integer,HashMap<Character,Integer>> ruleMap = new HashMap<>();
            HashMap<Character,Integer> inputMap0 = new HashMap<>();
            inputMap0.put('\t',0);
            inputMap0.put(' ',0);
            inputMap0.put('+',20);
            inputMap0.put('-',20);
            inputMap0.put('*',20);
            inputMap0.put('/',20);
            for(char i='0';i<='9';i++) {
                inputMap0.put(i, 10);
            }
            ruleMap.put(0,inputMap0);
            HashMap <Character,Integer> inputMap10 = new HashMap<>();
            inputMap10.put('\t', -1);
            inputMap10.put(' ', -1);
            inputMap10.put('+', -1);
            inputMap10.put('-' , -1);
            inputMap10.put('*' , -1);
            inputMap10.put('/' , -1);
            for(char i = '0' ; i <= '9' ; i++) {
                inputMap10.put(i, 10);
            }
            inputMap10.put('.',15);
            ruleMap.put(10,inputMap10);
            //state ==15
            HashMap <Character,Integer> inputMap15 = new HashMap<>();
            for(char i = '0' ; i <= '9' ; i++) {
                inputMap15.put(i, 16);
            }
            ruleMap.put(15,inputMap15);
            //state ==16
            HashMap <Character,Integer> inputMap16 = new HashMap<>();
            inputMap16.put('\t', -1);
            inputMap16.put(' ', -1);
            inputMap16.put('+', -1);
            inputMap16.put('-' , -1);
            inputMap16.put('*' , -1);
            inputMap16.put('/' , -1);
            for(char i = '0' ; i <= '9' ; i++) {
                inputMap16.put(i, 16);
            }
            ruleMap.put(16,inputMap16);

            //state =20
            HashMap <Character,Integer> inputMap20 = new HashMap<>();
            inputMap20.put('\t', -1);
            inputMap20.put(' ', -1);
            inputMap20.put('+', -1);
            inputMap20.put('-' , -1);
            inputMap20.put('*' , -1);
            inputMap20.put('/' , -1);
            for(char i = '0' ; i <= '9' ; i++) {
                inputMap20.put(i, -1);
            }
            ruleMap.put(20,inputMap20);

            while (!chars.isEmpty()) {

//			//查看队列头部
                char input = chars.peek();
                try {
                    HashMap <Character,Integer> inputMap =ruleMap.get(state);
                    state = inputMap.get(input);
                    if(state == null ) {
                        throw new IndexOutOfBoundsException();
                    }else if (state == 10 || state == 15 || state == 16 || state == 20) {
                        buffer.append(input);
                    }
                }catch(IndexOutOfBoundsException e) {
                    //无效的表达式
                    throw new IllegalArgumentException("无效表达式");
                }


                if(state == -1) {
////			//已完整输入(识别到）一个词
////			//重置为初始状态；
                    state = 0;
////			//记录该词
                    words.add(buffer.toString());
                    buffer.setLength(0);
                }else {
//			//还在当前词的输入（识别）过程中
                    chars.remove();
                }
            }
            if(buffer.length()>0) {
                words.add(buffer.toString());
            }
            //打印结果
            return words;

        }

    }




