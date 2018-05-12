package com.epam;

public class MatrixIterator {

    public byte[][] iterateMatrix(byte[][] startState, Integer countOfIteration) {
        System.out.println("Original");
        print(startState);
        System.out.println();
        for(int i = 0; i<countOfIteration; i++){
            startState = iterate(startState);
            System.out.println("Iterate "+(i+1));
            print(startState);
            System.out.println();
        }
        return startState;
    }

    private void print(byte[][] arr){
        for (byte[] anArr : arr) {
            for (byte anAnArr : anArr) {
                System.out.print(anAnArr + "\t");
            }
            System.out.println();
        }
    }

    private byte[][] iterate(byte[][] currentState){

        int height = currentState.length;
        int weight = currentState[0].length;

        byte[][] clone = currentState.clone();
        for (int i = 0; i < clone.length; i++) {
            clone[i] = currentState[i].clone();
        }
        for(int x=0; x<currentState.length; x++){
            for(int y=0; y<currentState[0].length; y++){
                if(currentState[x][y] == 3){
                    clone[x][y]+=100;
                    incrementNeighbor(clone, x - 1, y - 1, height, weight);
                    incrementNeighbor(clone, x, y - 1, height, weight);
                    incrementNeighbor(clone, x + 1, y - 1, height, weight);
                    incrementNeighbor(clone, x - 1, y, height, weight);
                    incrementNeighbor(clone, x + 1, y, height, weight);
                    incrementNeighbor(clone, x - 1, y + 1, height, weight);
                    incrementNeighbor(clone, x, y + 1, height, weight);
                    incrementNeighbor(clone, x + 1, y + 1, height, weight);
                }
                else if(currentState[x][y] > 103 || (currentState[x][y] >= 100 && currentState[x][y] < 102)){
                    clone[x][y]-=100;
                    decrementNeighbor(clone, x - 1, y - 1, height, weight);
                    decrementNeighbor(clone, x, y - 1, height, weight);
                    decrementNeighbor(clone, x + 1, y - 1, height, weight);
                    decrementNeighbor(clone, x - 1, y, height, weight);
                    decrementNeighbor(clone, x + 1, y, height, weight);
                    decrementNeighbor(clone, x - 1, y + 1, height, weight);
                    decrementNeighbor(clone, x, y + 1, height, weight);
                    decrementNeighbor(clone, x + 1, y + 1, height, weight);
                }
            }
        }
        return clone;
    }

    private void incrementNeighbor(byte[][] arr, int currentX, int currentY, int height, int weight) {
        int neighborX = (currentX < 0 ? height - 1 : currentX == height ? 0 : currentX);
        int neighborY = (currentY < 0 ? weight - 1 : currentY == weight ? 0 : currentY);
        arr[neighborX][neighborY]++;
    }
    private void decrementNeighbor(byte[][] arr, int currentX, int currentY, int height, int weight) {
        int neighborX = (currentX < 0 ? height - 1 : currentX == height ? 0 : currentX);
        int neighborY = (currentY < 0 ? weight - 1 : currentY == weight ? 0 : currentY);
        arr[neighborX][neighborY]--;
    }

}
