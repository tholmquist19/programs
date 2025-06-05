#include<stdio.h>
#include<stdlib.h>
#include"linkedList.h"


/*

YOU ARE ***NOT*** ALLOWED TO CHANGE THIS FILE

 */


linked_list * f(){
  linked_list *list, *list2;
  linked_list_node *node;
  int i;

  list = (linked_list *)malloc(sizeof(linked_list));
  if(list == NULL){
    fprintf(stderr, "Memory allocation failed for list.\n");
    exit(1);
  }
  list->head = list->tail = NULL;
  list->size = 0;

  list2 = (linked_list *)malloc(sizeof(linked_list));
  if(list2 == NULL){
    fprintf(stderr, "Memory allocation failed for list2.\n");
    exit(1);
  }
  list2->head = list2->tail = NULL;
  list2->size = 0;


  for(i = 0; i < 4; i++){
    node = (linked_list_node *)malloc(sizeof(linked_list_node));
    if(node == NULL){
      fprintf(stderr, "Memory allocation failed for list node.\n");
      exit(1);
    }
    node->key = i;
    node->next = NULL;
    list_add_first(list, node);
  }
  printf("****list****\n");
  list_print(list);

  for(i = 100; i < 104; i++){
    node = (linked_list_node *)malloc(sizeof(linked_list_node));
    if(node == NULL){
      fprintf(stderr, "Memory allocation failed for list node.\n");
      exit(1);
    }
    node->key = i;
    node->next = NULL;
    list_add_first(list2, node);
  }
  printf("****list2****\n");
  list_print(list2);


  printf("****** testing list_remove_last *****\n\n");

  printf("list_remove_last from list\n");
  node = list_remove_last(list);
  free(node);
  list_print(list);

  printf("list_remove_last from list\n");
  node = list_remove_last(list);
  free(node);
  list_print(list);

  printf("list_remove_last from list\n");
  node = list_remove_last(list);
  free(node);
  list_print(list);

  printf("list_remove_last from list\n");
  node = list_remove_last(list);
  free(node);
  list_print(list);

  printf("list_remove_last from list\n");
  node = list_remove_last(list);
  free(node);
  list_print(list);


  /*
  printf("populate list back\n");
  for(i = 0; i < 4; i++){
    node = (linked_list_node *)malloc(sizeof(linked_list_node));
    if(node == NULL){
      fprintf(stderr, "Memory allocation failed for list node.\n");
      exit(1);
    }
    node->key = i;
    node->next = NULL;
    list_add_first(list, node);
  }
  printf("****list****\n");
  list_print(list);
  */

  printf("\n****** testing list_add_last into list *****\n\n");

  node = (linked_list_node *)malloc(sizeof(linked_list_node));
  if(node == NULL){
    fprintf(stderr, "Memory allocation failed for list node.\n");
    exit(1);
  }
  node->key = 123;
  node->next = NULL;
  printf("list_add_last: %d\n", node->key);
  list_add_last(list, node);
  list_print(list);

  node = (linked_list_node *)malloc(sizeof(linked_list_node));
  if(node == NULL){
    fprintf(stderr, "Memory allocation failed for list node.\n");
    exit(1);
  }
  node->key = 111;
  node->next = NULL;
  printf("list_add_last: %d\n", node->key);
  list_add_last(list, node);
  list_print(list);

  node = (linked_list_node *)malloc(sizeof(linked_list_node));
  if(node == NULL){
    fprintf(stderr, "Memory allocation failed for list node.\n");
    exit(1);
  }
  node->key = 444;
  node->next = NULL;
  printf("list_add_last: %d\n", node->key);
  list_add_last(list, node);
  list_print(list);

  node = (linked_list_node *)malloc(sizeof(linked_list_node));
  if(node == NULL){
    fprintf(stderr, "Memory allocation failed for list node.\n");
    exit(1);
  }
  node->key = 333;
  node->next = NULL;
  printf("list_add_last: %d\n", node->key);
  list_add_last(list, node);
  list_print(list);



  printf("\n****** testing list_add_before into list *****\n\n");

  node = (linked_list_node *)malloc(sizeof(linked_list_node));
  if(node == NULL){
    fprintf(stderr, "Memory allocation failed for list node.\n");
    exit(1);
  }
  node->key = 999;
  node->next = NULL;
  printf("list_add_before: %d before the head node\n", node->key);
  list_add_before(list, list->head, node);
  list_print(list);

  node = (linked_list_node *)malloc(sizeof(linked_list_node));
  if(node == NULL){
    fprintf(stderr, "Memory allocation failed for list node.\n");
    exit(1);
  }
  node->key = 888;
  node->next = NULL;
  printf("list_add_before: %d before the tail node\n", node->key);
  list_add_before(list, list->tail , node);
  list_print(list);


  printf("\n****** testing list_remove_before from list *****\n\n");

  printf("list_remove_before: remove the node before the tail node\n");
  list_remove_before(list, list->tail);
  list_print(list);

  printf("list_remove_before: remove the node that is before head's next, i.e. remove the head itself\n");
  list_remove_before(list, list->head->next);
  list_print(list);


  printf("\n****** testing list_reverse_iterative of list *****\n\n");
  printf("list before reversed\n");
  list_print(list);
  printf("reverse the list\n");
  list_print(list_reverse_iterative(list));

  printf("remove the first node\n");
  list_remove_first(list);
  list_print(list);
  printf("reverse the list\n");
  list_print(list_reverse_iterative(list));

  printf("remove the first node\n");
  list_remove_first(list);
  list_print(list);
  printf("reverse the list\n");
  list_print(list_reverse_iterative(list));

  printf("remove the first node\n");
  list_remove_first(list);
  list_print(list);
  printf("reverse the list\n");
  list_print(list_reverse_iterative(list));

  printf("reverse the list\n");
  list_print(list_reverse_iterative(list));



  printf("\n****** testing list_remove_node from list *****\n\n");
  printf("First, let's add a few nodes into list\n\n");
  node = (linked_list_node *)malloc(sizeof(linked_list_node));
  if(node == NULL){
    fprintf(stderr, "Memory allocation failed for list node.\n");
    exit(1);
  }
  node->key = 888;
  node->next = NULL;
  printf("list_add_first: %d\n", node->key);
  list_add_first(list, node);
  list_print(list);

  node = (linked_list_node *)malloc(sizeof(linked_list_node));
  if(node == NULL){
    fprintf(stderr, "Memory allocation failed for list node.\n");
    exit(1);
  }
  node->key = 777;
  node->next = NULL;
  printf("list_add_first: %d\n", node->key);
  list_add_first(list, node);
  list_print(list);

  node = (linked_list_node *)malloc(sizeof(linked_list_node));
  if(node == NULL){
    fprintf(stderr, "Memory allocation failed for list node.\n");
    exit(1);
  }
  node->key = 666;
  node->next = NULL;
  printf("list_add_first: %d\n", node->key);
  list_add_first(list, node);
  list_print(list);

  printf("remove the second node\n");
  list_remove_node(list, list->head->next);
  list_print(list);

  printf("remove the head node\n");
  list_remove_node(list, list->head);
  list_print(list);

  printf("remove the tail node\n");
  list_remove_node(list, list->tail);
  list_print(list);

  printf("remove the only existing node\n");
  list_remove_node(list, list->tail);
  list_print(list);

  printf("\n****** testing list_free_all_nodes *****\n\n");
  printf("Let's first populate a list back\n");
  for(i = 0; i < 4; i++){
    node = (linked_list_node *)malloc(sizeof(linked_list_node));
    if(node == NULL){
      fprintf(stderr, "Memory allocation failed for list node.\n");
      exit(1);
    }
    node->key = i;
    node->next = NULL;
    list_add_first(list, node);
  }
  printf("****list****\n");
  list_print(list);
  printf("Free the entire list\n");
  list_free_all_nodes(list);
  list_print(list);


  /**********************************************************/


  printf("\n****** testing list_merge *****\n\n");
  printf("Let's first populate a list back\n");
  for(i = 0; i < 4; i++){
    node = (linked_list_node *)malloc(sizeof(linked_list_node));
    if(node == NULL){
      fprintf(stderr, "Memory allocation failed for list node.\n");
      exit(1);
    }
    node->key = i;
    node->next = NULL;
    list_add_first(list, node);
  }
  printf("****list****\n");
  list_print(list);
  printf("****list2****\n");
  list_print(list2);
  printf("list_merge list2 into the tail side of list\n\n");
  list_merge(list, list2);
  printf("list\n");
  list_print(list);
  printf("list2\n");
  list_print(list2);


  printf("list_merge list into the tail side of list2\n\n");
  list_merge(list2, list);
  printf("list\n");
  list_print(list);
  printf("list2\n");
  list_print(list2);


  printf("free up list2\n");
  list_free_all_nodes(list2);
  printf("list2\n");
  list_print(list2);
  printf("list\n");
  list_print(list);
  printf("merge the two empty lists\n");
  printf("after the merge ...\n");
  list_merge(list, list2);
  printf("list\n");
  list_print(list);
  printf("list2\n");
  list_print(list2);

  return list;
}



int main()
{
  linked_list *l;

  l = f();

  //list_print(l);

  return 0;
}
