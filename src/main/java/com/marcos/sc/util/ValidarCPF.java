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
		char digito_1 = '0';
		char digito_2= '0';
		
		//Parte 01
		for(int i= 0; i< 9; i++) { 
			String posicao = cpf.substring(i, i+1);
			
			soma_1 += Integer.parseInt(posicao) * numero_1;
			System.out.println(posicao + " " + numero_1 + " " + soma_1 );
			numero_1 = numero_1 - 1;
			
			digito_1 = (char) (11 - (soma_1 % 11));
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
			
			digito_2 = (char) (11 - (soma_2 % 11));
			if(digito_2 == 10 || digito_2 == 11) {
				digito_2 = '0';
			}
			
			
			
		
			
			
		}
		System.out.println(soma_2);
		System.out.println("Digito 2 : " + digito_2);
		
	
		
			
			if( digito_1 == cpf.charAt(9) && digito_2 == cpf.charAt(10)) {
				  return (true);
			} else return (false);
		
		
		
		
		
	}

}
