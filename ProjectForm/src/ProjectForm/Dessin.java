package ProjectForm;

import java.util.ArrayList;
import java.util.LinkedHashSet;

/**
 * <b>Dessin est la classe repr�sentant des collections contenant des images
 * <p>
 * Un Dessin est caract�ris�e par l'information suivante :
 * <ul>
 * <li>une ArrayList des images qui la composent.</li>
 * </ul>
 * </p>
 */
public class Dessin{
	//Attribut
		private ArrayList<Image> listeImage;
		
		
		//M�thodes
		/**
		 * Constructeur Dessin
		 * 
		 * @param images
		 * 				Une ArrayList des images contenues dans le Dessin
		 */
		public Dessin(ArrayList<Image> images) {
			this.listeImage = images;
		}

		/**
		 * Renvoi la liste des images qui constituent le Dessin
		 * 
		 * @return liste des images qui constituent le Dessin, sous forme de cha�ne de caract�re.
		 */
		@Override
		public String toString() {
			return "Dessin:\n" + listeImage + "]\n";
		}
		/**
		 * M�thode pour retourner un attribut d'un Dessin
		 * 
		 * @param int i
		 * 			Un int repr�sentant la position du point que l'on veut retourner.
		 * 
		 * @return attribut Image de l'arrayList � la position i
		 */
		public Image getImage(int i) {
			return listeImage.get(i);
		}
		/**
		 * Retirer les doublons d'un Dessin
		 * 
		 * @param ArrayList<Image> array
		 * 					array est l'ArrayList du Dessin � traiter
		 * 
		 * @return Dessin copi� sans doublons
		 */
		public Dessin retirerDoublons(ArrayList<Image> array){
			this.listeImage = array;
			LinkedHashSet<Image> hash = new LinkedHashSet<Image>(array);
			ArrayList<Image>array2 = new ArrayList<Image>(hash);
			return new Dessin(array2);
		}
		
		/**
		 * Renvoie un nouveau Dessin identique pivot� d'un angle "degree" dans le sens horaire.
		 * 
		 * @param degree
		 * 				La valeur de l'angle dont on souhaite pivoter le Dessin 
		 * 
		 * @return les param�tres du nouveau Dessin
		 */
		public Forme rotation(double degre) throws Exception {
			return null;
		}
		/**
		 * Renvoie un nouveau Dessin identique translat�e
		 * @param dx
		 * 			valeur de la translation selon l'axe horizontal x
		 * @param dy
		 * 			valeur de la translation selon l'axe vertical y 
		 * @return les param�tres du nouveau Dessin
		 */
		public Forme translation(int dx, int dy) {
			// TODO Auto-generated method stub
			return null;
		}
		/**
		 * Renvoie l'homothetie d'un nouveau Dessin copi�
		 * 
		 * @param k
		 * 			le facteur de l'homothetie
		 * 
		 * @return les param�tres du nouveau Dessin copi�
		 */
		public Forme homothetie(int k) {
			// TODO Auto-generated method stub
			return null;
		}
		/**
		 * Renvoi l'aire du Dessin
		 * 
		 * @return La valeur de l'aire du Dessin, sous forme de double.
		 */
		public double aire() {
			// TODO Auto-generated method stub
			return 0;
		}
		/**
		 * Renvoi le perimetre du Dessin
		 * 
		 * @return La valeur du perimetre du Dessin, sous forme de double.
		 */
		public double perimetre() {
			// TODO Auto-generated method stub
			return 0;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + ((listeImage == null) ? 0 : listeImage.hashCode());
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
			Dessin other = (Dessin) obj;
			if (listeImage == null) {
				if (other.listeImage != null)
					return false;
			} else if (!listeImage.equals(other.listeImage))
				return false;
			return true;
		}

		
}
