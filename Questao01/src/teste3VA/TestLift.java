package teste3VA;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestLift {

	//Teste que verifica se a funcao que aumentar o currentFloor funciona como esperado
	@Test
	public void testeUpFloor() {
		
		Lift lift = new Lift(10);
		
		lift.goUp();
		lift.goUp();
		
		assertEquals(lift.getCurrentFloor(),2);
	}
	//Função que testa se a função goUp() aumenta o andar atual quando esse é igual ao andar maximo
	@Test
	public void testeCurrentFloorEqualTopFloor() { 
		
		Lift lift = new Lift(10);
		
		for(int a = 0; a < lift.getTopFloor() + 5;a++)
		{
			lift.goUp();
		}
		
		assertEquals(lift.getCurrentFloor(),lift.getTopFloor());
		
	}
	//Função que testa se a função addRiders() não incrementa o numero de passageiros quando esse é igual ao numero maximo de passageiros
	@Test
	public void testeGetCapacity()
	{
		Lift lift = new Lift(10,5);
		
		lift.addRiders(lift.getCapacity() + 5);
		
		assertEquals(lift.getNumRiders(),lift.getCapacity());
	}
	
	//Função que testa se a função isFull() retorna corretament
	@Test
	public void testeIsFull()
	{
		Lift lift = new Lift(10,5);
		
		lift.addRiders(lift.getCapacity());
		
		assertEquals(lift.isFull(),true);
		
	}
	//Função que teste a função isFull() no caso em que é falso
	@Test
	public void testeIsFullFalse()
	{
		Lift lift = new Lift(10,5);
		
		lift.addRiders(lift.getCapacity() - 1);
		
		assertEquals(lift.isFull(),false);
	}
	
	//Função que testa que a função goDown() funciona corretamente quando o currentFloor é 0
	@Test
	public void testeGoDown0()
	{
		Lift lift = new Lift(10,5);
		
		lift.goDown();
		
		assertEquals(lift.getCurrentFloor(),0);

	}
	
	//Função que testa a função call() quando o elevador deve subir
	@Test
	public void testeSubirElevador()
	{
		Lift lift = new Lift(10,5);
		
		lift.call(5);
		
		assertEquals(lift.getCurrentFloor(),5);
	}
	
	//Função que testa a função call() quando o elevador deve descer
	@Test
	public void testeDescerElevador()
	{
		Lift lift = new Lift(10,5);
		
		lift.call(10);
		lift.call(2);
		
		assertEquals(lift.getCurrentFloor(),2);
	}
	
	//Função que testa a função call() quando o argumento é negativo
	@Test
	public void testeCallElevadorNegativo()
	{
		Lift lift = new Lift(10,5);
		
		lift.call(-1);

		assertEquals(lift.getCurrentFloor(),0);

	}
	
	//Função que testa a função call() quando o argumento é maior que o topFloor()
	@Test
	public void testeCallElevadorMaiorTopFloor()
	{
		Lift lift = new Lift(10,5);
		
		lift.call(20);

		assertEquals(lift.getCurrentFloor(),0);

	}

}
