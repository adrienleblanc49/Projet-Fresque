package ProjectForm;


/**
* Une énumération pour les couleurs suivantes : NOIR, ROUGE, BLEU, VERT.
*/
enum Couleur { NOIR, BLANC, BEIGE, ROSE; }

/**
* <b>Forme est la classe représentant la forme d'une figure géométrique.
* <p>
* Une Forme est caractérisée par les informations suivantes :
* <ul>
* <li>Son centre.</li>
* <li>Sa couleur.</li>
* </ul>
* </p>
*/
public  abstract class Forme implements Technique,Mesure {
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((centre == null) ? 0 : centre.hashCode());
		result = prime * result + ((couleur == null) ? 0 : couleur.hashCode());
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
		Forme other = (Forme) obj;
		if (centre == null) {
			if (other.centre != null)
				return false;
		} else if (!centre.equals(other.centre))
			return false;
		if (couleur != other.couleur)
			return false;
		return true;
	}

	protected Point centre;
	protected Couleur couleur;

	/**
  public Forme() {
      centre = new Point(0,0);
      this.couleur = Couleur.NOIR;
  }
	 */

	/**
	 * Constructeur Forme à 3 paramètres
	 * @param x
	 * 			La coordonnée du centre selon x.
	 * @param y
	 * 			La coordonnée du centre selon y.
	 * @param couleur
	 * 			La couleur de la Forme.
	 */
	public Forme(final int x, final int y, final Couleur couleur) {
		this.centre = new Point(x, y);
		this.couleur = couleur;
	}

	/**
	 * Constructeur Forme à l'origine.
	 * <p>
	 * La est construite à l'origine du repère en (0,0) et est prend la couleur NOIR.
	 * </p>
	 */
	public Forme() {
		this(0, 0, Couleur.NOIR);
	}


	/**
	 * Fonction abstraite concernant le périmètre de cette forme.
	 */
	public abstract double perimetre();
	/**
	 * Fonction abstraite concernant l'aire de cette forme.
	 */
	public abstract double aire();

	/** 
	 * Translate le centre de cette forme.
	 * @param dx
	 * 			Valeur du déplacement du point selon x.
	 * @param dy
	 * 			Valeur du déplacement du point selon y.
	 * 
	 * Cette mÃ©thode de translation du point central d'une forme
	 * n'a pas Ã  Ãªtre redÃ©fini dans les sous-classes.
	 */

	/**
	 * Renvoi les coordonnées du centre de cette forme et sa couleur.
	 * 
	 * @return Les coordonnées du centre et la couleur, sous forme de chaîne de caractère.
	 */
	@Override
	public String toString() {
		return centre + " " + couleur;
	}
	/**
	 * Renvoi la multiplication de deux matrices
	 * 
	 * @param MA
	 * 			premiere matrice 
	 * @param MB
	 * 			deuxieme matrice
	 * @return le produit des deux matrices
	 * 
	 * @throws Exception
	 * 			veille au respect des conditions necessaire a la multiplication de matrices
	 */
	static double[][] multiplier(double[][] MA, double[][] MB)throws Exception{
		
			double[][] MC;
	    
			int i,j;
		
			if(MA == null || MB == null){
				throw new Exception("L'une des deux matrices est à null");
			}

		
			if(MA[0].length != MB.length){
				throw new Exception("La multiplication de deux matrices n'est possible que si le nombre de colonne du premier est égal au nombre de ligne du second");
			}
		 
			
	
			i= MA.length;
			j= MB[0].length;
			MC = new double[i][j];
			i=0;
			for (int la = 0;la < MA.length;la++){ /// Ligne de MA
				j=0;
				for (int cb = 0;cb < MB[0].length;cb++){ /// colonne de  MB
            	
					double calcul= 0;
					for (int m = 0;m < MA[0].length;m++){  /// colone de MA et ligne de MB
                	
						
               	
						calcul += MA[la][m] * MB[m][cb];
						
					}

				
					MC[i][j] = (double)Math.round(calcul*100)/100;
					j++;
				}
				
				i++;
			}
	     
	     
			return MC;
		}
	
	/**
	 * affiche la matrice
	 * 
	 * @param M
	 * 			la matrice à afficher
	 * @throws Exception
	 * 			Verifie que la matrice n'est pas nulle
	 */
	static void afficher(double [][]M) throws Exception{
		if(M == null){
			throw new Exception("La matrice est à null");
		}
			for (int i = 0;i < M.length;i++){
				for (int j = 0;j < M[0].length ;j++){
					
					System.out.print(M[i][j] + " " );
				}
				System.out.println();
				}
				System.out.println();
	}

}
