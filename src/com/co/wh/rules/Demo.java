package com.co.wh.rules;

import com.co.wh.rules.ToValidate;

public class Demo {

    public static void main(String[] args) {

        Rule<Integer> rule = new Rule<Integer>();

        boolean response = rule.createRule("servicio", "servicio = 1");
        System.out.println(response);
        response = rule.execRule("servicio", 1);
        System.out.println(response);

        /*
         * ToValidate validate = new ToValidate("valor",
         * "valor > 3 or valor < 4 and valor > 6");
         * 
         * System.out.println(validate.getConditionName() + ": " +
         * validate.getConditionSentence());
         * 
         * System.out.println(
         * validate.getToValidate().getConditionName() + ": " +
         * validate.getToValidate().getConditionSentence());
         * 
         * System.out.println(
         * validate.getToValidate().getToValidate().getConditionName() + ": "
         * + validate.getToValidate().getToValidate().getConditionSentence());
         */
    }

}
