package listaDupla;

import caixa.Caixa;

public class ListaEncadeada<T extends IBuscavel> {

	private Caixa<T> novo;
	private Caixa<T> primeiro;
	private Caixa<T> cursor;
	private int size;

	public ListaEncadeada(){
		novo = null;
		primeiro = null;
		cursor = null;
		size = 0;
	}

	public void inserirFinal(T valor) {
		cursor = primeiro.getAnterior(); // ultimo
		
		// implementar metodo inserirApos(), para usa-lo aqui;
		
		
	}

	public void inserirInicio(T valor) {
		cursor = primeiro;
		inserirPosAtual(valor); // equivalente a "insere antes" (da forma que foi implementado)
		//System.out.printf("Elemento inserido no inicio: %s; primeiro: %s; cursor: %s\n", novo, primeiro, cursor);
	}

	public T retirarInicio() throws Exception {

		if (primeiro == null) throw new Exception("Fila vazia");

		T elemento = primeiro.getElemento();
		excluirInicio();
		return elemento;
	}

	public T retirarFinal() throws Exception {

		if (primeiro == null) throw new Exception("Fila vazia");

		T elemento = primeiro.getAnterior().getElemento();
		//System.out.println("Endereco do elemento a ser retirado do final: " + primeiro.getAnterior());
		excluirFinal();

		return elemento;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int getNumElementos() {
		return size;
	}

	// apenas para posicionar o cursor, para eventual leitura/escrita;
	public void buscar(T elemento) throws Exception {
		if (primeiro == null) throw new Exception("Fila vazia");
		
		if (cursor.getElemento() != elemento) { // caso ja seja o elemento, nao faz nada

			System.out.println("\n=== busca elemento ===");
			//System.out.println("Posicao atual do cursor: " + cursor);
			//Caixa<T> posicaoFake = cursor; //.getAnterior(); // posicao onde o elemento fake sera inserido
			inserirPosAtual(elemento); // fake
			Caixa<T> posicaoFake = cursor.getAnterior(); // posicao do fake;
			//avancarCursor();
			System.out.println("Elemento fake inserido na posicao: " + posicaoFake);
			while (cursor.getElemento() != elemento) {
				//System.out.println("Cursor vai para proxima posicao: " + cursor.getProximo());
				cursor = cursor.getProximo();
			}

			if (cursor != posicaoFake) {
				Caixa<T> posicaoEncontrado = cursor;
				System.out.println("Posicao onde elemento foi encontrado: " + cursor);
				cursor = posicaoFake; // preparar para exclusao do fake 
				excluirPosAtual();
				cursor = posicaoEncontrado;
				System.out.println("posicao do cursor ao deixar a busca: " + cursor);
				System.out.println("=== fim busca elemento ===\n");
			} else {
				excluirPosAtual();
				throw new Exception("Elemento nao encontrado");
			}
		}
		
	}

	public void excluirInicio() throws Exception {
		cursor = primeiro;
		excluirPosAtual();
		//System.out.printf("Elmento excluido do inicio da lista; primeiro: %s; cursor: %s\n", primeiro, cursor);
	}

	public void excluirFinal() throws Exception {
		cursor = primeiro.getAnterior();
		System.out.println("Elemento a ser excluido do final: " + cursor);
		excluirPosAtual();
	}

	public void excluirPosAtual() throws Exception {
		System.out.println("\nPosicao do cursor ao chegar no metodo para excluir atual: " + cursor);
		if (primeiro == null) throw new Exception("Fila vazia");

		if (size == 1) {				// ultimo elemento
			primeiro = cursor = null;	// apaga tudo, reset
		} else {
			
			if (cursor == primeiro) {
				primeiro = primeiro.getProximo();	// se era a primeira posicao, atualiza
			}
			
			cursor.getAnterior().setProximo(cursor.getProximo());
			cursor.getProximo().setAnterior(cursor.getAnterior());
			cursor = cursor.getProximo(); // aponta para o elemento posterior ao excluido
			//System.out.println("Posicao do cursor apos exclusao atual: \n" + cursor);
		}

		size--;
	}

	// vai ter que tomar cuidado quando so tiver um elemento
	public void excluirItem(T elemento) throws Exception {
		buscar(elemento); //posiciona o cursor
		excluirPosAtual();
	}

	public void inserirPosAtual(T elemento) {
		novo = new Caixa<T>(elemento); // assumindo memória infinita, etc
		if (primeiro == null) {
			primeiro = cursor = novo;
			primeiro.setAnterior(primeiro); // se so existe o primeiro elemento, ele aponta para ele mesmo
			primeiro.setProximo(primeiro);
			System.out.printf("Endereco primeiro elemento: %s\n", novo);

		} else {
			
			if (cursor == primeiro & size >= 1) {
				primeiro = novo;
			}
			
			System.out.println("Inserido novo elemento na posicao: " + novo);
			novo.setAnterior(cursor.getAnterior());
			novo.setProximo(cursor);
			cursor.getAnterior().setProximo(novo);
			cursor.setAnterior(novo);
			// cursor permanece igual, ou seja, aponta para o elemento apos o incluido
			System.out.println("Endereco cursor apos insercao " + cursor);
		}
		size++;

	}

	public void avancarCursor() {
		System.out.printf("Cursor avancou de %s para %s\n", cursor, cursor.getProximo());
		cursor = cursor.getProximo();
	}


	//  public void inserirApos(Item<T> item, T valor);
	//  
	//  public void inserirAntes(Item<T> item, T valor);
	//  
	//  public void excluirItem(Item<T> item);
	//  
	//  
	//  public Item<T> buscarItem(Item<T> item);




}
