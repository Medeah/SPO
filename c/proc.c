#include <time.h>
#include <stdio.h>
#include <stdlib.h>
#define SIZE 400000000

int proc(int a[]) {
  int sum = 0, i;
  for(i=0; i < SIZE; i++)
    sum +=a[i];
  return sum;
}

int main () {
	puts("hello");
	int i;
	int *a = (int*)malloc(SIZE * sizeof (int));
	for(i=0; i < SIZE; i++)
		a[i] = i;

	clock_t begin, end;
	double time_spent;
	puts("start timer");
	begin = clock();	

	/* here, do your time-consuming job */
	int res = proc(a);
	
	end = clock();
	puts("end timer");
	time_spent = (double)(end - begin) / CLOCKS_PER_SEC;

	printf("Time: %f\n", time_spent);
	printf("Res: %d\n", res);
}