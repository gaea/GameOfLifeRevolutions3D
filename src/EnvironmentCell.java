public class EnvironmentCell {

	private Cell environment[][][];
	private int width;
	private int heigth;
	private int deep;
	
	public EnvironmentCell(int width, int heigth, int deep){
		this.width = width;
		this.heigth = heigth;
		this.deep = deep;
		environment = new Cell [width][heigth][deep];
		
		for(int i=0; i<width; i++){
			for(int j=0; j<width; j++){
				for(int k=0; k<deep; k++){
					environment[i][j][k] = new Cell(false);
				}
			}
		}
	}
	
    public boolean checkNeighborsForPopulatedCell(int w, int h, int d){ //  if cell survives return true, if die false
    	int neighbors = checkNeighbors(w, h, d);
    	
    	if(neighbors == 2 || neighbors == 3){
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public boolean checkNeighborsForEmptyCell(int w, int h, int d){ //  if cell survives return true, if die false
    	int neighbors = checkNeighbors(w, h, d);
    	
    	if(neighbors ==  3){
    		return true;
    	}
    	else {
    		return false;
    	}
    }
    
    public int checkNeighbors(int w, int h, int d){
    	int neighbors = 0;
    	for(int i=w-1; i<w+2; i++){
    		for(int j=h-1; j<h+2; j++){
    			for(int k=d-1; k<d+2; k++){
    				if(i>=0 && i<width && j>=0 && j<heigth && k>=0 && k<deep && getCell(i, j, k).getState() == true){
    					if(!(i==w && j==h && k==d)){
    						neighbors++;
    					}
    				}
    			}
    		}
    	}
    	return neighbors;
    }

    public Cell[][][] getEnvironment(){
    	return environment;
    }
    
    public Cell getCell(int width, int heigth, int deep){
    	return environment[width][heigth][deep];
    }
    
    public void setCell(Cell cell, int width, int heigth, int deep){
    	environment[width][heigth][deep] = cell;
    }
    
    public void setEnvironment(Cell environment[][][]){
    	this.environment = environment;
    }
    
    public int getDeep(){
    	return width;
    }
    
    public void setDeep(int deep){
    	this.deep = deep;
    }
    
    public int getWidth(){
    	return width;
    }
    
    public void setWidth(int width){
    	this.width = width;
    }
    
    public int getHeigth(){
    	return heigth;
    }
    
    public void setHeigth(int heigth){
    	this.heigth = heigth;
    }
}