#include<stdio.h>
#include<stdlib.h>
#include"linkedList.h"


/*
  Reverse the give list so that every node's next points to the other direction.
  For example, say the given list is:  1->2-3, where 1 is the head node and 3 is the tail node.
  After the reverse call, the list becomes 1<-2<-3, i.e., 3->2->1,
  where 1 becomes the tail node and 3 becomes the head node.

  Return the reversed link list.
*/
linked_list * list_reverse_recursive(linked_list *list){
  linked_list_node * temp;
  
  if(list->size > 1){
    __list_reverse_sublist_recursive(list->head);

    temp = list->head;
    list->head = list->tail;
    list->tail = temp;
  }
  return list;
}


/*
   Helper method: only reverse the part of the linked list that starts at node 'start'.

   Return: the 'start' node where start->next is set to be NULL.
*/
linked_list_node * __list_reverse_sublist_recursive(linked_list_node *start){
  linked_list_node *temp;
  
  if(start->next == NULL)
    return start;

  temp = __list_reverse_sublist_recursive(start->next);
  temp->next = start;
  start->next = NULL;
  
  return start;
}



/*
  Reverse the give list so that every node's next points to the other direction.
  For example, say the given list is:  1->2-3, where 1 is the head node and 3 is the tail node.
  After the reverse call, the list becomes 1<-2<-3, i.e., 3->2->1,
  where 1 becomes the tail node and 3 becomes the head node.

  This function delivers the same functionality as what list_reverse_recursive does,
  but the code must not use recursion but only use iteration.

  Return the reversed link list.
*/
linked_list * list_reverse_iterative(linked_list *list){

linked_list_node *curr, *prev, *next;
curr = list->head;
prev = NULL;

while(curr != NULL){
    next = curr->next;
    curr->next = prev;
    prev = curr;
    curr=next;
}
list->head = prev;

return list;


}


/*
  Remove the 'node' from the 'list'.
  Note: the caller needs to ensure 'node' is a member node in 'list'.

  Return: the removed 'node'
*/

linked_list_node * list_remove_node(linked_list *list, linked_list_node *node){
  linked_list_node * curr = list->head;
 linked_list_node *temp;

  if(list == NULL || node == NULL)
      return NULL;
  if(list->size <= 1)
      return list_remove_first(list);
  if(node == list->head)
      return list_remove_first(list);
  if(node == list->tail)
      return list_remove_last(list);
  else{
      for(int i=0; curr->next!= node; i++)
          curr=curr->next;
      temp = curr->next;
      curr->next = curr->next->next;
      list->size--;
  }
  return temp;


  /* Reminder: You can be lazy here by calling some function(s) that we have implemented.
     Pick the right one(s) to make your code most efficient.*/
}




/*
  Free every node in the list, i.e., the list will be empty when this function returns.
  Return the empty list 'list'.

  Note: Free the nodes in the right way/order, so that your code will not have memory leak.
*/

linked_list * list_free_all_nodes(linked_list *list){
  linked_list_node *temp;

  if(list == NULL)
      return NULL;

  while(list->head!=NULL){
      temp=list->head;
      list->head=list->head->next;
      free(temp);
  }
  list->size=0;
  return list;


}




/* Merge list2 into the tail side of list1. Either list is allowed to be empty.
   Return: list1 as the new merged list.
   Note: 1) when the function returns, list2.head and list2.tail should all be NULL, and list2.size should be 0.
         2) To make your code efficient, your code must NOT traverse either list and must not copy/create any node.
*/

linked_list * list_merge(linked_list *list1, linked_list *list2){
    if(list1 == NULL || list2 == NULL)
        return NULL;
    
    if(list1->head == NULL && list1->tail == NULL && list2->head == NULL && list2->tail == NULL){
        return list1;
    }
    if(list1->head == NULL || list1->tail == NULL){
        list1=list2;
        list2->head = NULL;
        list2->tail = NULL;
        list2->size = 0;
        return list1;
    }
    else{
        list1->tail->next = list2->head;
        list1->tail = list2->tail;
        list1->size += list2->size;
        list2->head = NULL;
        list2->tail = NULL;
        list2->size = 0;
        return list1;
    }
}












linked_list_node * list_remove_after(linked_list *list, linked_list_node *node){
    linked_list_node * deleted;
  
  /* Sanity check */
  if(list == NULL || node == NULL)
    return NULL;
  if(node == list->tail)
    return NULL;
  if(node->next == list->tail)
    return list_remove_last(list);
  else{
    deleted = node->next;
    node->next = node->next->next;
    deleted->next = NULL;
    list->size --;
    return deleted;
  }
}

linked_list_node * list_remove_before(linked_list *list, linked_list_node *node){
    linked_list_node *temp, *curr;
    curr = list->head;

    if(list == NULL || node == NULL)
        return NULL;

    if(node == list->head)
        return NULL;
    if(node ==list->head->next)
        return list_remove_first(list);

    else{
        while(curr->next->next != node)
            curr=curr->next;
        temp = curr->next;
        curr->next = node;
        temp->next=NULL;
        list->size--;
        if(temp == list->head)
            node = list->head;
    }


    return temp;

}

linked_list * list_add_after(linked_list *list, linked_list_node *node1, linked_list_node *node2){

      /* Sanity check */
  if(list == NULL || node1 == NULL || node2 == NULL)
    return NULL;
  if(node1 == list->tail)
    return list_add_last(list, node2);
  else{
    node2->next = node1->next;
    node1->next = node2;
    list->size ++;
    return list;
  }
}

linked_list * list_add_before(linked_list *list, linked_list_node *node1, linked_list_node *node2){
    linked_list_node *curr = list->head;

    if(list == NULL || node1 == NULL || node2 == NULL)
        return NULL;

    if(node1 == list->head)
        list_add_first(list, node2);
    else{
        for(int i=0; curr->next != node1; i++)
            curr = curr->next;
        curr->next=node2;
        node2->next=node1;
        list->size++;
    }
    
    return list;
}

linked_list * list_add_last(linked_list *list, linked_list_node *node){
  
    if(list == NULL || node == NULL)
        return NULL;
    
    if(list->tail == 0){
        list->head = list->tail = node;
    }
    else{
        list->tail->next = node;
        list->tail=node;
    }
    list->size++;
    return list;
}


linked_list_node * list_remove_last(linked_list *list){
    linked_list_node *temp;
    linked_list_node *curr = list->head;

    if(list == NULL)
        return NULL;
    if(list->size == 0)
        return NULL;
    if(list->size == 1){
        temp = list->head;
        list->head = NULL;
        list->tail = NULL;
        list->size = 0;
    }
    else{
        for(int i=0; i<list->size-2; i++)
            curr = curr->next;
        temp = list->tail;
        list->tail=curr;
        list->tail->next = NULL;
        list->size--;
    }
    return temp;
}


linked_list_node * list_remove_first(linked_list *list){
    linked_list_node *ret;
  
  /* Sanity check */
  if(list == NULL)
    return NULL;
  
  if(list->size == 0)
    return NULL;
  ret = list->head;
  if(list->size == 1){
    list->head = NULL;
    list->tail = NULL;
  }
  else
    list->head = list->head->next;
  list->size --;
  ret->next = NULL;
  
  return ret;
}


linked_list * list_add_first(linked_list *list, linked_list_node *node){
  /*sanity checkings*/
  if(list == NULL || node == NULL)
    return NULL;
  
  if(list->size == 0){
    list->head = node;
    list->tail = node;
  }
  else{
    node->next = list->head;
    list->head = node;
  }
  list->size ++;
  return list;
}

/*
  Print the content of every node in the list.
  Return the number of nodes that are printed.
*/
int list_print(linked_list * list){
  linked_list_node *temp;
  int count = 0;

  printf("The nodes: ");
  for(temp = list->head; temp != NULL; temp = temp->next){
    printf("%d, ", temp->key);
    count ++;
  }
  
  printf("\nThe number of nodes printed: %d\n", count);
  printf("The recorded list size is: %d\n\n", list->size);

  return count;
}





