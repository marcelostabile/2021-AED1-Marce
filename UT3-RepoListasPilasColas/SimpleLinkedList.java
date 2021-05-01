public class SimpleLinkedList<T> implements ISimpleLInkedList<T>
{
    private ISimpleNode<T> head;
    private int lenght;

    @Override
    public ISimpleNode<T> getHead() 
    {
        return head;
    }

    @Override
    public void appendFirst(ISimpleNode<T> node) 
    {
        if(this.isEmpty())
        {
            this.head = node;
            this.lenght +=1;
        }
        else
        {
            node.setNext(head);
            this.head = node;
            this.lenght +=1;
        }
        
    }

    @Override
    public void appendAfterSpecificNode(ISimpleNode<T> node, ISimpleNode<T> position) 
    {
        if(this.isEmpty())
        {
            this.head = node;
        }
        else
        {
            node.setNext(this.search(position.getKey()).getNext());
            this.search(position.getKey()).setNext(node);
        }   
    }
    
    @Override
    public void appendLast(ISimpleNode<T> node) 
    {    
        // isEmpty -> head == null
        if (this.isEmpty())  
        {    
            this.head = node;
            this.lenght +=1;
        }
        else
        {
            ISimpleNode<T> current = this.getTail();

            // Set the last node found next node
            current.setNext(node);
            
            this.lenght+=1;
        }
    }

    @Override
    public ISimpleNode<T> search(Comparable key) 
    {
        // isEmpty -> head == null
        if (this.isEmpty()) 
        {
            //TO-DO ENTRY NOT FOUND
            return null;
        }
        else
        {
            ISimpleNode<T> current = head; 
            while(current.getNext() != null) 
            {    
                if (key.compareTo(current.getKey()) == 0) 
                {    
                    return current;
                }
                current = current.getNext();
            }
        }
        return null;
    }

    @Override
    public void searchAndDelete(Comparable key) 
    {
        if(this.isEmpty())
        {

        }
        else
        {
            if(key.compareTo(this.head.getKey()) == 0)
            {
                this.head = head.getNext();
                this.lenght -=1;
            }
            else
            {
                ISimpleNode<T> current = head; 
                while(current.getNext() != null) 
                {    
                    if (key.compareTo(current.getNext().getKey()) == 0) 
                    {    
                        ISimpleNode<T> theNextToTheOneToBeDeleted = current.getNext().getNext();
                        current.setNext(theNextToTheOneToBeDeleted);
                        this.lenght -=1;
                        break;
                    }   
                    current = current.getNext();
                }

                this.search(current.getKey()).setNext(null);
                this.lenght -=1;
            }
            
        }

    }

    @Override
    public String printNodesKeys() 
    {
        String keys = "";
        
        if(this.isEmpty())
        {
            return keys;
        }
        else
        {
            ISimpleNode<T> current = this.head;

            // Checks whether if the traversing node has the next link to null
            while (current.getNext() != null) 
            {
                keys = keys + current.getKey().toString();    
                current = current.getNext();
            }
            keys = keys + current.getKey().toString();

            return keys;
        }
        
    }

    @Override
    public String printNodesKeys(String separator) 
    {
        String keys = "";
        
        if(this.isEmpty())
        {
            return keys;
        }
        else
        {
            ISimpleNode<T> current = this.head;

            // Checks whether if the traversing node has the next link to null
            while (current.getNext() != null) 
            {
                keys = keys + separator + current.getKey().toString();    
                current = current.getNext();
            }

            keys = keys + separator + current.getKey().toString();
            
            return keys.replaceFirst(separator, "");
        }
    }

    @Override
    public int length() 
    {
        return this.lenght;
    }

    @Override
    public boolean isEmpty() 
    {
        return (this.head == null);
    }

    @Override
    public ISimpleNode<T> getTail() 
    {
        if(this.isEmpty())
        {
            return null;
        }
        else
        {
            ISimpleNode<T> current = this.head;

            // Checks whether if the traversing node has the next link to null
            while (current.getNext() != null) 
            {    
                current = current.getNext();
            }

            return current;
        }   
    }
}