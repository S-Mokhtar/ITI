#include <stdio.h>
#include <stdlib.h>

struct Node
{
    int Data;
    struct Node* pLeft;
    struct Node* pRight;
};
struct Node* CreateNode (int data);
struct Node* InsertNode(struct Node* pNode, int data);

int main()
{
    struct Node* pRoot = NULL;
    pRoot = InsertNode(pRoot, 17);
    InsertNode(pRoot, 7);
    InsertNode(pRoot, 24);
    InsertNode(pRoot, 12);
    InsertNode(pRoot, 9);
    InsertNode(pRoot, 15);
    InsertNode(pRoot, 20);
    printf("Preorder traversal: ");
    pre_order_traversal(pRoot);

    printf("\nInorder traversal: ");
    inorder_traversal(pRoot);

    printf("\nPost order traversal: ");
    post_order_traversal(pRoot);
    return 0;
}

struct Node* CreateNode(int data)
{
    struct Node* ptr;
    ptr = (struct Node*)malloc(sizeof(struct Node));
    if(ptr)
    {
        ptr->Data = data;
        ptr->pLeft = NULL;
        ptr->pRight = NULL;
    }
    return ptr;
}
struct Node* InsertNode(struct Node* pNode, int data)
{
    if(pNode == NULL)
    {
        pNode = CreateNode(data);
    }
    else if(pNode->Data >= data)
    {
        pNode->pLeft = InsertNode(pNode->pLeft, data);
    }
    else
    {
        pNode->pRight = InsertNode(pNode->pRight, data);
    }
    return pNode;
}

void pre_order_traversal(struct Node* root)
{
    if(root != NULL)
    {
        printf("%d ",root->Data);
        pre_order_traversal(root->pLeft);
        pre_order_traversal(root->pRight);
    }
}

void inorder_traversal(struct Node* root)
{
    if(root != NULL)
    {
        inorder_traversal(root->pLeft);
        printf("%d ",root->Data);
        inorder_traversal(root->pRight);
    }
}

void post_order_traversal(struct Node* root)
{
    if(root != NULL)
    {
        post_order_traversal(root->pLeft);
        post_order_traversal(root->pRight);
        printf("%d ", root->Data);
    }
}
