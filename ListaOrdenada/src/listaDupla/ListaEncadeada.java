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

	public void inserirFinal(T elemento) {
		if (primeiro == null) {
			cursor = primeiro;
		} 
		
//		else {
//			cursor = primeiro.getAnterior(); // ultimo
//		}
		
		System.out.println("\nPosicao do cursor para insercao no final: " + cursor);
		inserirAposAtual(elemento);
		
	}
	
	public void inserirInicio(T elemento) {
		cursor = primeiro;
		inserirAntesAtual(elemento);
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
//		System.out.printf("\n === Primeiro aponta para %s; endereco proximo: %s; endereco anterior: %s", primeiro, primeiro.getProximo(), primeiro.getAnterior());
//		System.out.println("\nElemento a ser retirado do final: " + primeiro.getAnterior().getElemento().getCodigo());
		excluirFinal();

		return elemento;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int getNumElementos() {
		return size;
	}
	
	/**
	 * Esta funcao apenas posiciona o cursor no elemento buscado, caso exista.
	 * Se o elemento buscado nao existir, o cursor volta para a posicao anterior a busca.
	 * @param ID - codigo (int) a ser buscado
	 * @throws Exception - indica fila vazia ou elemento nao encontrado
	 */
	public void buscar(int ID) throws Exception {
		if (primeiro == null) throw new Exception("Fila vazia");
				
		if (cursor.getElemento().getCodigo() != ID) { // caso ja seja o elemento, nao faz nada
			
			//gambiarra para criar um fake do tipo correto
			T fake = (T) cursor.getElemento().getFake(ID);
			
			System.out.printf("\ncodigo do fake criado da classe Aluno: %d\n", fake.getCodigo());
			
			System.out.println("\n=== busca elemento ===");
			System.out.println("Posicao atual do cursor: " + cursor);
			inserirAntesAtual(fake);
			Caixa<T> posicaoFake = cursor.getAnterior(); // posicao do fake;
			//avancarCursor();
			System.out.println("Elemento fake inserido na posicao: " + posicaoFake);
			while (cursor.getElemento().getCodigo() != ID) {
				System.out.println("Endereco do cursor: " + cursor);
				System.out.println("Codigo lido no cursor: " + cursor.getElemento().getCodigo());
				System.out.println("Cursor vai para proxima posicao: " + cursor.getProximo());
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
	//	System.out.println("Elemento a ser excluido do final: " + cursor);
		excluirPosAtual();
	}

	public void excluirPosAtual() throws Exception {
		//System.out.println("\nPosicao do cursor ao chegar no metodo para excluir atual: " + cursor);
		if (primeiro == null) throw new Exception("Fila vazia");

		if (size == 1) {				// ultimo elemento
			primeiro = cursor = null;	// apaga tudo, reset
		} else {
			
			if (cursor == primeiro) {
				primeiro = primeiro.getProximo();	// se era a primeira posicao, atualiza
			}
			
			cursor.getAnterior().setProximo(cursor.getProximo());
			cursor.getProximo().setAnterior(cursor.getAnterior());
			cursor = cursor.getAnterior(); //cursor.getAnterior(); //Proximo(); // aponta para o elemento posterior ao excluido
		//	System.out.println("Posicao do cursor apos exclusao atual: " + cursor);
		}

		size--;
	}

	// vai ter que tomar cuidado quando so tiver um elemento
	public void excluirItem(int ID) throws Exception {
		buscar(ID); //posiciona o cursor
		excluirPosAtual();
	}

	/**
	 * "Insere Antes"
	 * Insere o elemento especificado antes do atual; apos a inclusao o cursor aponta para a posicao original
	 * @param elemento a ser incluido
	 */
	public void inserirAntesAtual(T elemento) {
		novo = new Caixa<T>(elemento); // assumindo memória infinita, etc
		if (primeiro == null) {
			primeiro = cursor = novo;
			primeiro.setAnterior(primeiro); // se so existe o primeiro elemento, ele aponta para ele mesmo
			primeiro.setProximo(primeiro);

		} else {
			
			// se for inserir na primeira posicao, atualiza o ponteiro para o primeiro elemento
			if (cursor == primeiro & size >= 1) {
				primeiro = novo;
			}
			
			novo.setAnterior(cursor.getAnterior());
			novo.setProximo(cursor);
			cursor.getAnterior().setProximo(novo);
			cursor.setAnterior(novo);
		}
		size++;

	}
	
	/**
	 * Insere o elemento apos a posicao atual. Apos a insercao, o cursor aponta para o elemento inserido.
	 * @param elemento - elemento a ser inserido na fila
	 */
	public void inserirAposAtual(T elemento) {
		novo = new Caixa<T>(elemento); // assumindo memória infinita, etc
		if (primeiro == null) {
			primeiro = cursor = novo;
			primeiro.setAnterior(primeiro); // se so existe o primeiro elemento, ele aponta para ele mesmo
			primeiro.setProximo(primeiro);
			System.out.println("\n*** Criado primeiro elemento na posicao " + novo);
			System.out.printf("Primeiro: %s; cursor: %s; ultimo: %s\n", primeiro, cursor, primeiro.getAnterior());

		} else {
			
//			// se for inserir na ultima posicao, atualiza o ponteiro para o ultimo elemento
//			if (cursor == primeiro.getAnterior() & size >= 1) {
//				primeiro.setAnterior(novo);
//			}
			
			System.out.println("\n*** Criado novo elemento na posicao: " + novo);
			novo.setAnterior(cursor);
			novo.setProximo(cursor.getProximo());
			cursor.getProximo().setAnterior(novo);
			cursor.setProximo(novo);
			cursor = novo;
			System.out.println("\nApos da insercao, o cursor fica na posicao : " + cursor);
			System.out.printf("Primeiro: %s; cursor: %s; ultimo: %s\n", primeiro, cursor, primeiro.getAnterior());
		}
		size++;

	}
	

	public void avancarCursor() {
		System.out.printf("Cursor avancou de %s para %s\n", cursor, cursor.getProximo());
		cursor = cursor.getProximo();
	}
}