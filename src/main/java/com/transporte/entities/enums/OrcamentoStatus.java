package com.transporte.entities.enums;

public enum OrcamentoStatus {

	Proposta(1),
	Recusado(2),
	Aceito(3);
	
	 private int code;
	
	 private OrcamentoStatus(int code) {
		 this.code = code;
	 }
	 
	 public int getCode(){
		 return code; 
	 }
	 
	 public static OrcamentoStatus valueOf(int code) {
		   for(OrcamentoStatus value : OrcamentoStatus.values()){
			   if(value.getCode() == code) {
				   return value;
			   }
		   }
		throw new IllegalArgumentException("--> OrcamentoStatus status invalido ");
	 }
	
}
