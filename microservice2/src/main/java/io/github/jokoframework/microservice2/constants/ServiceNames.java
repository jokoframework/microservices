package io.github.jokoframework.microservice2.constants;

public enum ServiceNames {
    MICROSERVICE1("microservice1");

    private final String code;

    ServiceNames(String code){
        this.code = code;
    }

    public String code(){
        return code;
    }

}
