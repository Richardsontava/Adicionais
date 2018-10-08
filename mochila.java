public class mochila{
	public static void main(String[] args){
		nova_mochila obj = new nova_mochila();
		int peso[] = {3,4,7,9,12,13};
		int valor[] = {20,30,32,35,75,80};
		int peso_mochila = 20,total = 0;
		total = obj.valorMaximo(peso,valor,peso_mochila);
		System.out.println("\nO valor máximo é " + total);
	}
	public int valorMaximo(int peso[],int valor[],int peso_mochila){
		int matriz[][] = new int [peso.length + 1][peso_mochila + 1];
		for(int i = 1; i <= peso.length;i++){
			for(int j = 1; j <= peso_mochila;j++){
				if(peso[i - 1] <= j){
					matriz[i][j] = valor[i - 1] + matriz[i - 1][j - peso[i - 1]];
					if(matriz[i - 1][j] > matriz[i][j]){
						matriz[i][j] = matriz[i - 1][j];
					}
				}
				else{
					matriz[i][j] = matriz[i - 1][j];
				}
			}
		}
		for(int i = peso.length; i >= 0;i +=0){
			for(int j = peso_mochila; j >= 0;j +=0){
				if(matriz[i][j] != matriz[i - 1][j]){
					System.out.println("O ladrão vai levar o item "+i+" de "+peso[i - 1]+" kg e R$ "+valor[i - 1]);
					j -= peso[i - 1];
					i--;
				}
				else{
					i--;
				}
				if(i == 0){
					i--;
					break;
				}
			}
		}
	return matriz[peso.length][peso_mochila];
	}
}