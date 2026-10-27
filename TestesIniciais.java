/** Exercícios iniciais de uso das estruturas flexíveis Fila<E> e Pilha<E>. */
public class TestesIniciais {
	public static void main(String[] args) {
		Fila<Integer> fila = new Fila<>();
		Pilha<Integer> pilha = new Pilha<>();

		// Dígitos distintos da matrícula 885047.
		int[] digitos = {8, 5, 0, 4, 7};
		for (int digito : digitos) {
			fila.enfileirar(digito);
			pilha.empilhar(digito);
		}

		System.out.println("Pilha inicial:");
		pilha.imprimir();
		System.out.println("Fila inicial:");
		fila.imprimir();

		System.out.println("Topo removido: " + pilha.desempilhar());
		System.out.println("Primeiro da fila removido: " + fila.desenfileirar());
		System.out.println("Pilha após remoção:");
		pilha.imprimir();
		System.out.println("Fila após remoção:");
		fila.imprimir();
	}
}
