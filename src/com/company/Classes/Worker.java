package com.company.Classes;

import java.io.Serializable;
import java.time.LocalDate;

public class Worker implements Serializable {
    private String surname;
    private Position position;
    private LocalDate signing_contract;
    private LocalDate contract_end;
    private int income;

    public Worker(final String surname,final Position position,final int income){
        this.setSurname(surname);
        this.position=position;
        this.signing_contract = LocalDate.now().minusYears((int) (Math.random() * 4)).minusMonths((int) (Math.random() * 13)).minusDays((int) (Math.random() * 20));
        this.setContract_end();
        this.setIncome(income);
    }
    public void setSurname(String surname){
        this.surname=Utilities.correctingSurname(surname);
    }
    public  String getSurname(){
        return surname;
    }
    public  void  setPosition(final Position position){this.position=position;}

    public Position getPosition(){return  position;}

    public void setSigning_contract(final LocalDate date){this.signing_contract=date;}

    public LocalDate getSigning_contract(){return signing_contract;}

    public void setContract_end(){this.contract_end=getSigning_contract().plusYears(5);}

    public  LocalDate getContract_end(){return contract_end;}

    public void setIncome(final int income){
        this.income=Utilities.correctingIncome(income);
    }
    public String toString(){
        return "Worker["+
                "Surname=" + surname +
                ", position=" + position +
                ", date of signing the contract=" + signing_contract +
                ", contract end=" + contract_end +
                ", income=" + income +
                "]";
    }
}
