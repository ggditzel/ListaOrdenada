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
		cursorParaUltimo();
		inserirAposAtual(elemento);
		
	}
	
	public void inserirInicio(T elemento) {
		cursorParaPrimeiro();
		inserirAntesAtual(elemento);
	}

	public T retirarInicio() throws Exception {

		if (primeiro == null) throw new FilaVaziaException();

		T elemento = primeiro.getElemento();
		excluirInicio();
		return elemento;
	}

	public T retirarFinal() throws Exception {

		if (primeiro == null) throw new FilaVaziaException();

		T elemento = primeiro.getAnterior().getElemento();
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
		if (primeiro == null) throw new FilaVaziaException();
				
		if (cursor.getElemento().getCodigo() != ID) { // caso ja seja o elemento, nao faz nada
			
			//gambiarra para criar um fake do tipo correto
			T fake = (T) cursor.getElemento().getFake(ID);
			inserirAntesAtual(fake);
			Caixa<T> posicaoFake = cursor.getAnterior(); // posicao do fake;

			while (cursor.getElemento().getCodigo() != ID) {
				cursor = cursor.getProximo();
			}

			if (cursor != posicaoFake) {
				Caixa<T> posicaoEncontrado = cursor;
				cursor = posicaoFake; // preparar para exclusao do fake 
				excluirPosAtual();
				cursor = posicaoEncontrado;
			} else {
				excluirPosAtual();
				throw new ElementoNaoEncontradoException();
			}
		}
		
	}
	
	public void excluirInicio() throws Exception {
		cursorParaPrimeiro();
		excluirPosAtual();
	}

	public void excluirFinal() throws Exception {
		cursorParaUltimo();
		excluirPosAtual();
	}

	public void excluirPosAtual() throws Exception {
		if (primeiro == null) throw new FilaVaziaException();

		if (size == 1) {				// ultimo elemento
			primeiro = cursor = null;	// apaga tudo, reset
		} else {
			
			if (cursor == primeiro) {
				primeiro = primeiro.getProximo();	// se era a primeira posicao, atualiza
			}
			
			cursor.getAnterior().setProximo(cursor.getProximo());
			cursor.getProximo().setAnterior(cursor.getAnterior());
			cursor = cursor.getAnterior(); //cursor.getAnterior(); //Proximo(); // aponta para o elemento posterior ao excluido
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

		} else {
			
			novo.setAnterior(cursor);
			novo.setProximo(cursor.getProximo());
			cursor.getProximo().setAnterior(novo);
			cursor.setProximo(novo);
			cursor = novo;
		}
		size++;

	}
	

	public void avancarCursor() {
		cursor = cursor.getProximo();
	}
	
	public void voltarCursor() {
		cursor = cursor.getAnterior();
	}
	
	public T lerAtual() throws Exception {
		if (primeiro == null) throw new FilaVaziaException();
		return cursor.getElemento();
	}
		
	public void cursorParaPrimeiro () {
		cursor = primeiro;
	}
	
	public void cursorParaUltimo() {
		if (primeiro == null) {
			cursor = primeiro;
		}
		else {
			cursor = primeiro.getAnterior();
		}
	}
}