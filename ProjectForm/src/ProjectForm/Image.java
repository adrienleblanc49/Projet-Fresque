package ProjectForm;
import java.util.ArrayList;
import java.util.LinkedHashSet;

/**
 * <b>Image est la classe représentant des collections contenant des formes
 * <p>
 * Une image est caractérisée par l'information suivante :
 * <ul>
 * <li>une ArrayList des formes qui la composent.</li>
 * </ul>
 * </p>
 */
public class Image implements Technique, Mesure {
	
	//Attribut
	private ArrayList<Forme> listeForme;
	
	
	//Méthodes
	/**
	 * Constructeur Image
	 * 
	 * @param formes
	 * 				Une ArrayList des formes contenues dans l'Image 
	 */
	public Image(ArrayList<Forme> formes) {
		this.listeForme = formes;
	}

	/**
	 * Renvoi la liste des formes qui constituent l'Image
	 * 
	 * @return liste des formes qui constituent l'Image, sous forme de chaîne de caractère.
	 */
	@Override
	public String toString() {
		String s = "Image:\n";
		for(int i = 0; i < listeForme.size(); i++) {
			 s += listeForme.get(i) +"\n";
		}
		return s ;
	}
	/**
	 * Méthode pour retourner un attribut d'une Image
	 * 
	 * @param int i
	 * 			Un int représentant la position du point que l'on veut retourner.
	 * 
	 * @return attribut Forme de l'arrayList à la position i
	 */
	public Forme getForme(int i) {
		return listeForme.get(i);
	}
	/**
	 * Retirer les doublons d'une Image
	 * 
	 * @param ArrayList<Forme> array
	 * 					array est l'ArrayList de l'image à traiter
	 * 
	 * @return Image copiée sans doublons
	 */
	public Image retirerDoublons(ArrayList<Forme> array){
		this.listeForme = array;
		LinkedHashSet<Forme> hash = new LinkedHashSet<Forme>(array);
		ArrayList<Forme>array2 = new ArrayList<Forme>(hash);
		return new Image(array2);
	}
	
	/**
	 * Renvoie une nouvelle Image identique pivoté d'un angle "degree" dans le sens horaire.
	 * 
	 * @param degree
	 * 				La valeur de l'angle dont on souhaite pivoter le forme 
	 * 
	 * @return les paramètres de la nouvelle Image
	 */
	@Override
	public Forme rotation(double degre) throws Exception {
		return null;
	}
	/**
	 * Renvoie une nouvelle Image identique translatée
	 * @param dx
	 * 			valeur de la translation selon l'axe horizontal x
	 * @param dy
	 * 			valeur de la translation selon l'axe vertical y 
	 * @return les paramètres de la nouvelle Image
	 */
	@Override
	public Forme translation(int dx, int dy) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Renvoie l'homothetie d'une une nouvelle Image copiée
	 * 
	 * @param k
	 * 			le facteur de l'homothetie
	 * 
	 * @return les paramètres de la nouvelle Image copiée
	 */
	@Override
	public Forme homothetie(int k) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Renvoi l'aire de l'Image.
	 * 
	 * @return La valeur de l'aire de l'Image, sous forme de double.
	 */
	@Override
	public double aire() {
		// TODO Auto-generated method stub
		return 0;
	}
	/**
	 * Renvoie le perimetre de l'Image.
	 * 
	 * @return La valeur du perimetre de l'Image, sous forme de double.
	 */
	@Override
	public double perimetre() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((listeForme == null) ? 0 : listeForme.hashCode());
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
		Image other = (Image) obj;
		if (listeForme == null) {
			if (other.listeForme != null)
				return false;
		} else if (!listeForme.equals(other.listeForme))
			return false;
		return true;
	}



}

