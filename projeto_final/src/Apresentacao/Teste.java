package Apresentacao;

import java.io.*;
import java.io.ObjectInputStream.GetField;
import java.util.*;

import Negocio.*;
import Persistencia.*;
public class Teste {
	public static void main(String[] args) {
		Conexao con = new Conexao();
		ArrayList<Cliente> cli=new ArrayList<Cliente>();
		Scanner l= new Scanner(System.in);
		int codigo=0;
		String nome="";
		double renda=0.0;
		String endereco="";
		String cpf_cnpj="";
		double limite=0.0;
		cli = con.getClientes();
		System.out.println("clientes adicionados");
		for(int i=0;i<cli.size();i++){
			System.out.println(cli.get(i).getNome());
		}
		
		FileWriter arq;
		try {
			arq = new FileWriter("clientes.txt");
			PrintWriter gravarArq = new PrintWriter(arq,true);
			int tipo=0;
			System.out.println("1-f\n2-j");
			tipo=l.nextInt();
			
			System.out.println("n� da conta:");
			codigo=l.nextInt();
			System.out.println("nome:");
			nome=l.next();
			System.out.println("renda:");
			renda=l.nextDouble();
			System.out.println("endere�o:");
			endereco=l.next();
			l.next();
			System.out.println("cpf/cnpj:");
			cpf_cnpj=l.next();
			l.next();
			System.out.println("limite:");
			limite=l.nextDouble();
			
			FileWriter fr = new FileWriter("dados.csv");
			BufferedWriter arq2 = new BufferedWriter(fr);
			for (int i=0; i<cli.size(); i++){
				//arq.write(func.elementAt(i).getNome() + ";" + func.elementAt(i).getCod() + ";" + func.elementAt(i).getSal() + ";" + func.elementAt(i).getDep() + ";" + func.elementAt(i).getTemp() + "\n");
			}
			arq.close();
			if(tipo==1){
				gravarArq.printf("f;"+codigo+";"+nome+";"+renda+";"+endereco+";"+cpf_cnpj+";"+limite);
			}else if(tipo==2){
				gravarArq.printf("j;"+codigo+";"+nome+";"+renda+";"+endereco+";"+cpf_cnpj+";"+limite);
			}
			gravarArq.printf("sdad");

			gravarArq.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
//		if(cli.get(1).getSaldo()!=200){//if que trata de tranferencias o 200 seria substituido por valor de transferencia
//			System.out.println("como seu saldo foi insuficiente s� foi poss�vel fazer a transfer�ncia do valor de seu saldo");
//		}
		
	}

}
