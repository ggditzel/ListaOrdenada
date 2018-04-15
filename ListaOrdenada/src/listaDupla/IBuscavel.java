package listaDupla;

public interface IBuscavel {
	
	/**
	 * Retorna o codigo para buscas por ID
	 * @return
	 */
	public int getCodigo();
	
	
	/**
	 * 
	 * @param codigo
	 */
	public void setCodigo(int codigo);
	
	/**
	 * A classe que implementa esta interface deve ser capaz de retornar uma instancia de sua propria classe.
	 * @param ID - ID que sera utilizado para tal instancia.
	 * @return Instancia que implementa IBuscavel.
	 */
	public IBuscavel getFake(int ID);

}
