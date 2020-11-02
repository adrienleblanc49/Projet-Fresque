package ProjectForm;

import java.util.ArrayList;
import java.util.LinkedHashSet;

/**
 * <b>Dessin est la classe repr�sentant des collections contenant des dessins
 * <p>
 * Un Dessin est caract�ris� par l'information suivante :
 * <ul>
 * <li>une ArrayList des dessins qui la composent.</li>
 * </ul>
 * </p>
 */
public class Fresque{
	//Attribut
		private ArrayList<Dessin> listeDessin;
		
		
		//M�thodes
		/**
		 * Constructeur Fresque
		 * 
		 * @param dessins
		 * 				Une ArrayList des dessins contenues dans le Fresque
		 */
		public Fresque(ArrayList<Dessin> dessins) {
			this.listeDessin = dessins;
		}

		/**
		 * Renvoi la liste des dessins qui constituent le Fresque
		 * 
		 * @return liste des dessins qui constituent le Fresque, sous forme de cha�ne de caract�re.
		 */
		@Override
		public String toString() {
			return "FRESQUE:\n" + listeDessin + "]\n";
		}
		/**
		 * M�thode pour retourner un attribut d'un Fresque
		 * 
		 * @param int i
		 * 			Un int repr�sentant la position du point que l'on veut retourner.
		 * 
		 * @return attribut dessin de l'arrayList � la position i
		 */
		public Dessin getDessin(int i) {
			return listeDessin.get(i);
		}
		/**
		 * Retirer les doublons d'un Fresque
		 * 
		 * @param ArrayList<Dessin> array
		 * 					array est l'ArrayList du Fresque � traiter
		 * 
		 * @return Fresque copi� sans doublons
		 */
		public Fresque retirerDoublons(ArrayList<Dessin> array){
			this.listeDessin = array;
			LinkedHashSet<Dessin> hash = new LinkedHashSet<Dessin>(array);
			ArrayList<Dessin>array2 = new ArrayList<Dessin>(hash);
			return new Fresque(array2);
		}
		
		/**
		 * Renvoie un nouveau Fresque identique pivot� d'un angle "degree" dans le sens horaire.
		 * 
		 * @param degree
		 * 				La valeur de l'angle dont on souhaite pivoter le Fresque 
		 * 
		 * @return les param�tres du nouveau Fresque
		 */
		public Forme rotation(double degre) throws Exception {
			return null;
		}
		/**
		 * Renvoie un nouveau Fresque identique translat�e
		 * @param dx
		 * 			valeur de la translation selon l'axe horizontal x
		 * @param dy
		 * 			valeur de la translation selon l'axe vertical y 
		 * @return les param�tres du nouveau Fresque
		 */
		public Forme translation(int dx, int dy) {
			// TODO Auto-generated method stub
			return null;
		}
		/**
		 * Renvoie l'homothetie d'un nouveau Fresque copi�
		 * 
		 * @param k
		 * 			le facteur de l'homothetie
		 * 
		 * @return les param�tres du nouveau Fresque copi�
		 */
		public Forme homothetie(int k) {
			// TODO Auto-generated method stub
			return null;
		}
		/**
		 * Renvoi l'aire du Fresque
		 * 
		 * @return La valeur de l'aire du Fresque, sous forme de double.
		 */
		public double aire() {
			// TODO Auto-generated method stub
			return 0;
		}
		/**
		 * Renvoi le perimetre du Fresque
		 * 
		 * @return La valeur du perimetre du Fresque, sous forme de double.
		 */
		public double perimetre() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((listeDessin == null) ? 0 : listeDessin.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Fresque other = (Fresque) obj;
			if (listeDessin == null) {
				if (other.listeDessin != null)
					return false;
			} else if (!listeDessin.equals(other.listeDessin))
				return false;
			return true;
		}
		
		

}
