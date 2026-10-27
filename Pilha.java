import java.util.NoSuchElementException;
import java.util.ArrayList;

public class Pilha<E> {

	private Celula<E> topo;
	private Celula<E> fundo;

	public Pilha() {

		Celula<E> sentinela = new Celula<E>();
		fundo = sentinela;
		topo = sentinela;

	}

	public boolean vazia() {
		return fundo == topo;
	}

	public void empilhar(E item) {

		topo = new Celula<E>(item, topo);
	}

	public E desempilhar() {

		E desempilhado = consultarTopo();
		topo = topo.getProximo();
		return desempilhado;

	}

	public E consultarTopo() {

		if (vazia()) {
			throw new NoSuchElementException("Nao há nenhum item na pilha!");
		}

		return topo.getItem();

	}

	public void imprimir() throws IllegalStateException {

		Celula<E> aux;

		if (vazia())
			throw new IllegalStateException("Pilha vazia!");
		else {
			aux = topo;
			while (aux != fundo) {
				System.out.println(aux.getItem().toString());
				aux = aux.getProximo();
			}
		}
	}

	
	public Pilha<E> subPilha(int numItens) {
		
		if (numItens < 0)
			throw new IllegalArgumentException("A quantidade de itens não pode ser negativa.");
		if (numItens > tamanho())
			throw new IllegalArgumentException("A quantidade solicitada excede o tamanho da pilha.");

		Pilha<E> subPilha = new Pilha<>();
		Celula<E> atual = topo;
		ArrayList<E> itens = new ArrayList<>(numItens);
		for (int i = 0; i < numItens; i++) {
			itens.add(atual.getItem());
			atual = atual.getProximo();
		}
		for (int i = numItens - 1; i >= 0; i--)
			subPilha.empilhar(itens.get(i));
		return subPilha;
	}

	/** Retorna o número de elementos atualmente na pilha. */
	public int tamanho() {
		int tamanho = 0;
		for (Celula<E> atual = topo; atual != fundo; atual = atual.getProximo())
			tamanho++;
		return tamanho;
	}
}
