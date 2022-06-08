package com.co.wh.rules;

import java.util.HashMap;
import java.util.Map;

public class Rule<T> implements IRule<T> {

    private Map<String, ToValidate> reglas;

    public Rule() {
        this.reglas = new HashMap<String, ToValidate>();

    }

    @Override
    public boolean createRule(String name, String rule) {

        if (this.reglas.containsKey(name)) {

            return false;
        }

        ToValidate validate = new ToValidate(name, rule);
        this.reglas.put(name, validate);

        if (this.reglas.containsKey(name)) {

            return true;
        }

        return false;

    }

    @Override
    public boolean execRule(String name, T... parms) {

        if (!this.reglas.containsKey(name)) {
            return false;
        }
        if (parms.length == 0) {
            return false;
        }

        ToValidate validate = this.reglas.get(name);
        boolean response = true;

        for (int index = 0; index < parms.length && validate.getToValidate() != null; index++) {
            ////////////////////
            System.out.println("ingresa");
            /////////////////// 777

            T value = parms[index];
            Object sentenceValue = validate.getValue();

            switch (validate.getOperador().getOperator()) {
                case "=":
                    String sValue0 = sentenceValue + "";
                    String sValue_1 = value + "";
                    Integer value0 = Integer.parseInt(sValue0);
                    Integer value_1 = Integer.parseInt(sValue_1);

                    response = value0 == value_1 && response;

                    break;
                case "<":

                    String sValue1 = sentenceValue + "";
                    String sValue2 = value + "";
                    Integer value1 = Integer.parseInt(sValue1);
                    Integer value2 = Integer.parseInt(sValue2);
                    response = (value2 < value1) && response;

                    break;
                case ">":
                    String sValue3 = sentenceValue + "";
                    String sValue4 = value + "";
                    Integer value3 = Integer.parseInt(sValue3);
                    Integer value4 = Integer.parseInt(sValue4);
                    response = value4 > value3;

                    break;
                case "!=":

                    response = !sentenceValue.equals(value);

                    break;
                default:

                    break;
            }

            validate = validate.getToValidate();

        }

        return response;
    }

    public boolean execRule(String name, T parm) {

        if (!this.reglas.containsKey(name)) {
            return false;
        }

        ToValidate validate = this.reglas.get(name);
        boolean response = true;

        do {

            T value = parm;
            Object sentenceValue = validate.getValue();

            switch (validate.getOperador().getOperator()) {
                case "=":
                    String sValue0 = sentenceValue + "";
                    String sValue_1 = value + "";
                    //////////////////////////////// 7
                    System.out.println("type: " + sValue0.getClass().getSimpleName());
                    /////////////////////////////// 77

                    /*
                     * if (sValue0.getClass().getSimpleName().equals("String")) {
                     * String value0 = "";
                     * } else {
                     * 
                     * Integer value0 = Integer.parseInt(sValue0);
                     * Integer value_1 = Integer.parseInt(sValue_1);
                     * }
                     */
                    Integer value0 = Integer.parseInt(sValue0);
                    Integer value_1 = Integer.parseInt(sValue_1);
                    if (validate.getAndOr() == null) {
                        ////////////////////
                        System.out.println("1");
                        /////////////////// 777
                        response = value0 == value_1 || response;
                    } else if (validate.getAndOr().isAndOr()) {
                        ////////////////////
                        System.out.println("2");
                        /////////////////// 777
                        response = value0 == value_1 || response;
                        // response = value0 == value_1 && response;
                    } else {
                        ////////////////////
                        System.out.println("3");
                        /////////////////// 777
                        response = value0 == value_1 && response;
                        // response = value0 == value_1 || response;
                    }

                    break;
                case "<":

                    String sValue1 = sentenceValue + "";
                    String sValue2 = value + "";
                    Integer value1 = Integer.parseInt(sValue1);
                    Integer value2 = Integer.parseInt(sValue2);
                    // response = (value2 < value1) && response;
                    System.out.println("<");

                    if (validate.getAndOr() == null) {
                        ////////////////////
                        System.out.println("1");
                        /////////////////// 777
                        response = value2 < value1 || response;
                    } else if (validate.getAndOr().isAndOr()) {
                        ////////////////////
                        System.out.println("2");
                        /////////////////// 777
                        response = value2 < value1 || response;
                        // response = value0 == value_1 && response;
                    } else {
                        response = value2 < value1 && response;
                        ////////////////////
                        System.out.println("3" + " " + response + " " + value1 + " " + value2);
                        /////////////////// 777

                        // response = value0 == value_1 || response;
                    }

                    break;
                case ">":
                    String sValue3 = sentenceValue + "";
                    String sValue4 = value + "";
                    Integer value3 = Integer.parseInt(sValue3);
                    Integer value4 = Integer.parseInt(sValue4);
                    // response = (value4 > value3) && response;

                    if (validate.getAndOr() == null) {
                        ////////////////////
                        System.out.println("1");
                        /////////////////// 777
                        response = value4 > value3 || response;
                    } else if (validate.getAndOr().isAndOr()) {
                        ////////////////////
                        System.out.println("2");
                        /////////////////// 777
                        response = value4 > value3 || response;
                        // response = value0 == value_1 && response;
                    } else {
                        ////////////////////
                        System.out.println("3");
                        /////////////////// 777
                        response = value4 > value3 && response;
                        // response = value0 == value_1 || response;
                    }

                    break;
                case "!=":

                    response = !sentenceValue.equals(value);

                    break;
                default:

                    break;
            }

            validate = validate.getToValidate();

        } while (validate.getToValidate() != null);

        return response;

    }

    @Override
    public boolean deleteRule(String name) {
        if (this.reglas.containsKey(name)) {
            return false;
        }
        this.reglas.remove(name);
        if (!this.reglas.containsKey(name)) {
            return true;
        }
        return false;

    }

    public Map<String, ToValidate> getReglas() {
        return reglas;
    }

    public ToValidate getValue(String rule) {
        if (!this.reglas.containsKey(rule)) {
            return null;
        } else {
            return this.reglas.get(rule);
        }

    }

}
