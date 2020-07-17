package com.transporte.entities.enums;

public enum MudancaStatus {

	Iniciada(1),
	Recusado(2),
	Terminada(3);
	
	 private int code;
	
	 private MudancaStatus(int code) {
		 this.code = code;
	 }
	 
	 public int getCode(){
		 return code; 
	 }
	 
	 public static MudancaStatus valueOf(int code) {
		   for(MudancaStatus value : MudancaStatus.values()){
			   if(value.getCode() == code) {
				   return value;
			   }
		   }
		throw new IllegalArgumentException("--> MudancaStatus status invalido ");
	 }
	
}
