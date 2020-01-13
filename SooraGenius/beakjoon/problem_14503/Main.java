package com.company;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	private static int height;
	private static int width;

	private static int x;
	private static int y;
	private static int direction;
	private static int map[][];

	private static int UP = 0;
	private static int RIGHT = 1;
	private static int DOWN = 2;
	private static int LEFT = 3;

	private static int DIRTY = 0;
	private static int WALL = 1;
	private static int CLEAN = 2;
	public static void main(String[] args) throws Exception{
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer tokenizer = null;

		tokenizer = new StringTokenizer(reader.readLine());
		height = Integer.parseInt(tokenizer.nextToken());
		width = Integer.parseInt(tokenizer.nextToken());

		tokenizer = new StringTokenizer(reader.readLine());
		y = Integer.parseInt(tokenizer.nextToken());
		x = Integer.parseInt(tokenizer.nextToken());
		direction = Integer.parseInt(tokenizer.nextToken());

		map = new int[width][height];
		for(int i = 0; i<height; i++) {
			tokenizer = new StringTokenizer(reader.readLine());
			for(int j = 0; j<width; j++) {
				map[j][i] = Integer.parseInt(tokenizer.nextToken());
			}
		}
		int result = 0;
		while(true) {
			printMap();
			if(map[x][y] == DIRTY) {
				map[x][y] = CLEAN;
				result++;
			}else if(getLeftValue() == DIRTY) {
				turnLeft();
				go();
			}else if(getLeftValue() != DIRTY) {
				boolean isContinue = false;
				int orgDirection = direction;
				for(int i = 0; i<4; i++) {
					if(getLeftValue() == DIRTY) {
						turnLeft();
						go();
						isContinue = true;
						break;
					}
					turnLeft();
					printMap();
				}
				if(isContinue) {
					continue;
				}
				direction = orgDirection;

				int backValue = back();
				if(backValue == WALL) {
					break;
				}
			}
		}
		System.out.println(result);
	}

	public static int getLeftValue() {
		turnLeft();
		int leftValue = go();
		back();
		turnRight();
		return leftValue;
	}
	public static void turnLeft() {
		if(direction == UP) {
			direction = LEFT;
		}else if(direction == LEFT) {
			direction = DOWN;
		}else if(direction == DOWN) {
			direction = RIGHT;
		}else if(direction == RIGHT) {
			direction = UP;
		}
	}
	public static void turnRight() {
		if(direction == UP) {
			direction = RIGHT;
		}else if(direction == LEFT) {
			direction = UP;
		}else if(direction == DOWN) {
			direction = LEFT;
		}else if(direction == RIGHT) {
			direction = DOWN;
		}
	}
	public static int go() {
		if(direction == UP) {
			y—;
		}else if(direction == LEFT) {
			x—;
		}else if(direction == DOWN) {
			y++;
		}else if(direction == RIGHT) {
			x++;
		}
		return map[x][y];
	}
	public static int back() {
		if(direction == UP) {
			y++;
		}else if(direction == LEFT) {
			x++;
		}else if(direction == DOWN) {
			y—;
		}else if(direction == RIGHT) {
			x—;
		}
		return map[x][y];
	}
	static boolean isReal = true;
	public static void printMap() throws InterruptedException {
	}
}