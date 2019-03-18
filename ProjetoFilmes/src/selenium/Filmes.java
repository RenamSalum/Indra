package selenium;
import java.util.Date;

import net.bytebuddy.dynamic.DynamicType.Builder.MethodDefinition.ExceptionDefinition;

class Filmes {
	private String nome;
	private Data dataLancamento;
	
	public Filmes(){}
	public Filmes(String nome, Data data){
		this.nome = nome;
		this.dataLancamento = data;
	}
	public String getNome(){
		return this.nome;
	}
	public Data getData(){
		return this.dataLancamento;
	}
}

class Diretor {
	private String nome;
	private Data dataNascimento;
	Filmes[] filmes;
	private int livre = 0;
	
	public void setNome(String nome){
		this.nome = nome;
	}
	public String getNome(){
		return this.nome;
	}
	
	public Diretor(String nome, Data data, int n) {
		this.nome = nome;
		this.dataNascimento = data;
		this.filmes = new Filmes[n];
	}
	public void adicionar(Filmes f) {
		this.filmes[this.livre] = f;
		this.livre++;
	}
	public void Exibe() {
		System.out.println("Nome Diretor: " + this.nome);
		System.out.println("Data Nascimento: " + this.dataNascimento.getFormatada());
		
		for(int n = 0;filmes.length>n;n++) {
			System.out.println("Nome do Filme: " + this.filmes[n].getNome());
			System.out.println("Data Lançamento: " + this.filmes[n].getData().getFormatada());
		}
		
	}
}


class Data{
	private int dia;
	private int mes;
	private int ano;
	
	public Data(){
		
	}
	public Data(int dia, int mes, int ano){
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
		
		if(!dataVerdadeira(dia,mes,ano)){
			System.out.println("A data " + getFormatada() + "Não existe");
		}
	}
	public void setData(int dia, int mes, int ano){
		this.dia = dia;
		this.mes = mes;
		this.ano = ano;
	}
	public String getFormatada(){
		return this.dia + "/" + this.mes + "/" + this.ano;
	}
	public boolean dataVerdadeira(int dia,int mes, int ano){
		if(dia <= 0 || mes <= 0	){
			return false;
		}
		int ultimoDiaDoMes = 31;
		if(mes == 4 || mes == 6 || mes == 9 || mes == 11){
			ultimoDiaDoMes = 30;
		}else if(mes == 2){
			ultimoDiaDoMes = 28;
		}
		if(dia > ultimoDiaDoMes){
			return false;
		}
		return true;
		
	}
}

class Sistema{
	static String nomeFilme;
	static String nomeDiretor;
	public static void main(String[]args){
		Data diretorNascimento = new Data(20,9,1976);
		Diretor diretor = new Diretor("Anna Boden",diretorNascimento,2);
		
		Data filmeLancamento = new Data(8,3,2019);
		Filmes filme = new Filmes("Capitã Marvel",filmeLancamento);
		diretor.adicionar(filme);
		
		Data filmeLancamento1 = new Data(20,9,2015);
		Filmes filme1 = new Filmes("Mississippi Grind",filmeLancamento1);
		diretor.adicionar(filme1);

		diretor.Exibe();
		
		nomeDiretor = diretor.getNome();
		nomeFilme =	diretor.filmes[0].getNome();
		
		
	}
}

