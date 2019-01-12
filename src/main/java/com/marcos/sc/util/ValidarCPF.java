package com.marcos.sc.util;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ValidarCPF {
	
	public static boolean cpfValido(String cpf) {
		
		if(cpf.length() != 11) {
			return false;
		}
		
		int numero_1 = 10;
		int numero_2 = 11;
		int soma_1 = 0;
		int soma_2 = 0;
		int digito_1 = 0;
		int digito_2 = 0;
		
		//Parte 01
		for(int i= 0; i< 9; i++) { 
			String posicao = cpf.substring(i, i+1);
			
			soma_1 += Integer.parseInt(posicao) * numero_1;
			System.out.println(posicao + " " + numero_1 + " " + soma_1 );
			numero_1 = numero_1 - 1;
			
			digito_1 = (11 - (soma_1 % 11));
			if(digito_1 == 10 || digito_1 == 11) {
				digito_1 = '0';
			}
			
			
			
		
			
			
		}
		System.out.println(soma_1);
		System.out.println("Digito 1 : " + digito_1);
		
		System.out.println("=======================================================");
		
		//Parte 02
		for(int i= 0; i< 10; i++) { 
			String posicao = cpf.substring(i, i+1);
			
			soma_2 += Integer.parseInt(posicao) * numero_2;
			System.out.println(posicao + " " + numero_2 + " " + soma_2 );
			numero_2 = numero_2 - 1;
			
			digito_2 =(11 - (soma_2 % 11));
			if(digito_2 == 10 || digito_2 == 11) {
				digito_2 = '0';
			}
			
			
			
		
			
			
		}
		System.out.println(soma_2);
		System.out.println("Digito 2 : " + digito_2);
		
	
		String d1 =  Integer.toString(digito_1);
		String d2 = Integer.toString(digito_2);
		
		String dr1 = cpf.substring(9,10) ;
		String dr2 = cpf.substring(10,11) ;
		
		
		System.out.println("caracter na possicao 9: " + dr1);
		System.out.println("caracter na possicao 10: " + dr2);
		
		if( d1.equals(dr1) && d2.equals(dr2)  ) {
				  return (true);
		} else return (false);
		
		
		
		
		
	}

}
