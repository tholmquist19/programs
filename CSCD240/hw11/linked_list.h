#ifndef __LINKED_LIST__
#define __LINKED_LIST__


typedef struct node{
  int key;
  struct node * next;
}linked_list_node;


typedef struct{
  linked_list_node * head;
  linked_list_node * tail;
  int size;
}linked_list;


linked_list * list_add_first(linked_list *list, linked_list_node *node);
linked_list * list_add_last(linked_list *list, linked_list_node *node);
linked_list_node * list_remove_first(linked_list *list);
linked_list_node * list_remove_last(linked_list *list);

linked_list * list_add_after(linked_list *list, linked_list_node *node1, linked_list_node *node2);
linked_list * list_add_before(linked_list *list, linked_list_node *node1, linked_list_node *node2);
linked_list_node * list_remove_after(linked_list *list, linked_list_node *node);
linked_list_node * list_remove_before(linked_list *list, linked_list_node *node);

linked_list * list_reverse_recursive(linked_list *list);
linked_list_node * __list_reverse_sublist_recursive(linked_list_node *start);
linked_list * list_reverse_iterative(linked_list *list);
linked_list_node * list_remove_node(linked_list *list, linked_list_node *node);
linked_list * list_free_all_nodes(linked_list *list);
linked_list * list_merge(linked_list *list1, linked_list *list2);


int list_print(linked_list * list);

#endif

