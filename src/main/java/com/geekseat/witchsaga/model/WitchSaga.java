package com.geekseat.witchsaga.model;

import java.math.BigDecimal;

public class WitchSaga {
    private Person person1;
    private Person person2;
    private String description;
    private BigDecimal resultValue;

    private WitchSaga() {
    }

    public Person getPerson1() {
        return person1;
    }

    public Person getPerson2() {
        return person2;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getResult() {
        return resultValue;
    }

    public static class WitchSagaBuilder {
        private Person person1;
        private Person person2;
        private String description;
        private BigDecimal resultValue;

        public WitchSagaBuilder() {
        }

        public WitchSagaBuilder withPerson1(Person person1){
            this.person1 = person1;
            return this;
        }

        public WitchSagaBuilder withPerson2(Person person2){
            this.person2 = person2;
            return this;
        }

        public WitchSagaBuilder withDescription(String description){
            this.description = description;
            return this;
        }

        public WitchSagaBuilder withResultValue(BigDecimal resultValue){
            this.resultValue = resultValue;
            return this;
        }

        public WitchSaga build(){
            WitchSaga witchSaga = new WitchSaga();
            witchSaga.person1 = this.person1;
            witchSaga.person2 = this.person2;
            witchSaga.description = this.description;
            witchSaga.resultValue = this.resultValue;
            return witchSaga;
        }
    }
}
