package com.co.wh.rules;

public class ToValidate {

    private Operator operador;
    private Condition condition;
    private Object value;
    private AndOr andOr;
    private ToValidate toValidate;

    public ToValidate() {

    }

    public ToValidate(String ConditionName, String condition) {
        this.condition = new Condition(ConditionName, condition);
        this.operador = new Operator();
        separateString(condition);

        // ToValidate toValidate = separateString(condition);

        // this.toValidate = toValidate.getToValidate();

        /*
         * this.operador = toValidate.getOperador();
         * this.condition = toValidate.getCondition();
         * this.value = toValidate.getValue();
         * this.andOr = toValidate.getAndOr();
         * this.toValidate = toValidate.getToValidate();
         */
        /*
         * this.toValidate.setAndOr(toValidate.getAndOr());
         * this.toValidate.setCondition(toValidate.getCondition());
         * this.toValidate.setOperador(toValidate.getOperador());
         * this.toValidate.value = toValidate.getValue();
         * this.toValidate.setToValidate(toValidate.getToValidate());
         */
    }

    public ToValidate(String conditionName, String condicion, String operator, Object value) {

        this.condition = new Condition(conditionName, condicion);
        this.operador = new Operator(operator);
        this.value = value;

    }

    public ToValidate(Operator operador, Condition condition, Object value2) {
        this.operador = operador;
        this.condition = condition;
        this.value = value2;
        this.andOr = null;
        this.toValidate = null;
    }

    public ToValidate(Operator operador, Condition condition, Object value, AndOr andOr, ToValidate toValidate) {
        this.operador = operador;
        this.condition = condition;
        this.value = value;
        this.andOr = andOr;
        this.toValidate = toValidate;
    }

    private void separateString(String sentencia) {

        String[] comandos = sentencia.split(" ");
        String conditionName = "";
        String operador = "";
        Object value = new Object();
        String andOr;
        ToValidate validate = null;
        boolean masUnaCondicion = false;

        for (int index = 0; index < comandos.length; index++) {

            switch (index) {
                case 0:
                    String sentence = sentencia;
                    this.condition.setSentence(sentence);
                    break;
                case 1:
                    operador = comandos[1];
                    this.operador.setOperator(operador);

                    break;
                case 2:
                    value = comandos[2];
                    this.value = value;
                    break;
                case 3:
                    andOr = comandos[3];
                    masUnaCondicion = true;
                    String subSentencia = sentencia.split(" " + andOr + " ")[0].trim() + " " + andOr;
                    //////////////////////////////////////// 77
                    System.out.println(subSentencia);
                    //////////////////////////////////////// 77

                    sentencia = sentencia.replaceFirst(subSentencia, "");
                    sentencia = sentencia.trim();
                    boolean andOrbool = andOr.equals("and") ? true : false;
                    this.andOr = new AndOr(andOrbool);
                    //////////////////////////////////////// 77
                    System.out.println(andOr + "condicional....." + andOrbool + " " + sentencia);
                    //////////////////////////////////////////

                    validate = new ToValidate(this.condition.getName() + "-subCond", sentencia);
                    // validate = new ToValidate(new Operator(operador), new
                    // Condition(conditionName, sentencia), value,
                    // new AndOr(andOrbool), separateString(sentencia));

                    break;
                default:

                    break;

            }
        }

        // System.out.print(" end --- operador: " + operador + " conditionName: " +
        // conditionName + "value" + value);
        if (!masUnaCondicion) {

            validate = new ToValidate(new Operator(operador), new Condition(conditionName, sentencia),
                    value);

        }

        this.toValidate = validate;

    }

    public boolean validateRule(Object... parms) {

        return false;

    }

    public Operator getOperador() {
        return operador;
    }

    public void setOperador(Operator operador) {
        this.operador = operador;
    }

    public Condition getCondition() {
        return condition;
    }

    public void setCondition(Condition condition) {
        this.condition = condition;
    }

    public String getConditionName() {
        return condition.getName();
    }

    public String getConditionSentence() {
        return condition.getSentence();
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public AndOr getAndOr() {
        return andOr;
    }

    public void setAndOr(AndOr andOr) {
        this.andOr = andOr;
    }

    public ToValidate getToValidate() {
        return toValidate;
    }

    public void setToValidate(ToValidate toValidate) {
        this.toValidate = toValidate;
    }

}