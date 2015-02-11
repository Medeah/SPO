// first cpp program
 
#include <iostream>
#include <string>

using namespace std;

class Employee {
  public:
    string name;
    int social_number;
    int age;
    string department;
    int salary;
};

int main () {
  int n = 2;
  Employee a[n];
  a[0].name = "Bjarne";
  a[0].social_number = 1234;
  a[0].age = 64;
  a[0].department = "Computer Science";
  a[0].salary = 1000000;

  a[1].name = "Frederik";
  a[1].social_number = 1234;
  a[1].age = 24;
  a[1].department = "Engineering & Design";
  a[1].salary = 0;

  for (int i = 0; i < n; ++i)
  {
    cout << a[i].name << endl;
  }
  return 0;
}



