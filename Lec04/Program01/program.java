package Lec04.Program01;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

/**
 * program
 */
public class program {

    public static void main(String[] args) {
        LinkedList<Integer> lL = new LinkedList<Integer>();
        Queue<Integer> queue = new LinkedList<Integer>();
        Deque<Integer> deque = new LinkedList<Integer>();
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
        pq.add(123);
        pq.add(3);
        pq.add(13);
        pq.add(1);


        //FILO
        Stack<Integer> st = new Stack<Integer>();

        st.addAll(pq);
        System.out.println(st);
        System.out.println(st.pop());

        System.out.println(st.peek());


        System.out.println(pq);
        System.out.println(pq.poll());
        System.out.println(pq.poll());
        System.out.println(pq.remove());
        System.out.println(pq.poll());
        System.out.println(pq.poll());


        // 1+2*3
        // 123*+

        //(1+2)*3
        // 12+3*

        System.out.println(postfix_calculator("2 2 2 / +"));

    }


    public static double postfix_calculator(String expr)
    {
    Stack<Double> st = new Stack<>();
        char [] exp = expr.replace(" ", "").toCharArray();
        double res = 0.f;
    for (int i = 0; i < exp.length; i++)
    {
        if(exp[i] > 47 && exp[i] < 58)
        {
            st.push(exp[i] - 48.0);
        }
        else
        {
            switch (exp[i])
            {
                case '+':
                res = st.pop() + st.pop();
                st.push(res);
                break;
                case '-':
                res = st.pop()- st.pop();
                st.push(res);
                break;
                case '*':
                res = st.pop() * st.pop();
                st.push(res);
                break;
                case '/':
                res = st.pop() / st.pop();
                st.push(res);
                break;
            }

        }
    }
    return res;

    }
    

    


}