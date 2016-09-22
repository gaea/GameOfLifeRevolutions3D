import javax.swing.*;

public class GameOfLifeRevolutions {

	private EnvironmentCell environment;
	
	public GameOfLifeRevolutions(int width, int heigth, int deep){
		environment = new EnvironmentCell(width, heigth, deep);
		loadPopulatedCells();
	}
	
	public void loadPopulatedCells(){
		environment.getCell(5,5,5).setState(true);
		environment.getCell(5,6,5).setState(true);
		environment.getCell(5,7,5).setState(true);
	}
	
	public void play(){
		EnvironmentCell environmentTemp;
		environmentTemp = new EnvironmentCell(environment.getWidth(), environment.getHeigth(), environment.getDeep());
		for(int i=0; i<environment.getWidth(); i++){
			for(int j=0; j<environment.getHeigth(); j++){
				for(int k=0; k<environment.getDeep(); k++){
					if(environment.getCell(i, j, k).getState()){
						if(environment.checkNeighborsForPopulatedCell(i,j,k) == true){
							environmentTemp.getCell(i, j, k).setState(true);
						}
						else{
							environmentTemp.getCell(i, j, k).setState(false);
						}
					}
					else{
						if(environment.checkNeighborsForEmptyCell(i, j, k)){
							environmentTemp.getCell(i, j, k).setState(true);
						}
					}
				}
			}
		}
		environment = environmentTemp;
	}
	
	public EnvironmentCell getEnvironmentCell(){
		return environment;
	}
}