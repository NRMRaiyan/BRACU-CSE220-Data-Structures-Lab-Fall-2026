/*You will have to complete the FruitNode Contrustor first
 then within this class you only have to complete two methods
 hashFunction() and insert()
 the rest of the metods are already written
 DO NOT TOUCH any other methods or codes*/
public class HashTable {

    //ht[] :: is the HashTable array that stores the FruitNode objects
    private FruitNode[] ht;

    //Constructor that initializes the HashTable array
	//DO NOT change this Constructor
    public HashTable(int size){
        this.ht = new FruitNode[size];
    }
    
    //This method basically prints the HashTable
    //DO NOT change this method
    public void show(){
        for(int i=0; i<ht.length; i++){
            System.out.print( i+" " );
            FruitNode n = ht[i];
            while (n!=null){
                System.out.print("('"+n.fruit[0]+"', "+n.fruit[1]+") --> ");
                n = n.next;
            }
            System.out.println();
        }
    }

    //you need to COMPLETE this method
    private int hashFunction( String key ){
        // TO DO
        int keyLength = key.length();
        int asciiSum = 0;

        if(keyLength % 2 == 0){
            for(int i = 0; i < keyLength - 2; i += 2){
                asciiSum += (int)key.charAt(i);
            }
        }else{
            for(int i = 1; i < keyLength - 2; i += 2){
                asciiSum += (int)key.charAt(i);
            }
        }
        return asciiSum % ht.length; //remove this line
    }

    //you need to COMPLETE this method
    //The insert() method will create a FruitNode using name(Key) & price(value)
	//then inserts it in the proper hashed index
    //If collision occurs resolve using the steps explained in the question
    public void insert(String key, Integer value){
        int index=hashFunction(key);

        if (ht[index]==null) {
            FruitNode newNode = new FruitNode(key, value);
            ht[index] = newNode;
        }else{
            FruitNode curr=ht[index];
            while (curr!=null) {
                if (curr.fruit[0].equals(key)) {
                    curr.fruit[1]=value;
                    return ;
                }
                else{
                    curr=curr.next;
                }
            }

            curr=ht[index];

            if (value>(Integer)curr.fruit[1]) {
                FruitNode newNode = new FruitNode(key, value);
                newNode.next=curr;
                ht[index]=newNode;
            }else{
                while (curr.next!=null) {
                    FruitNode Next=curr.next;
                    if (value>(Integer)Next.fruit[1] && Next!=null) {
                        FruitNode newNode = new FruitNode(key, value);
                        newNode.next=Next;
                        curr.next=newNode;
                        return ;
                    }
                    else{
                        curr=curr.next;
                    }

                }

                curr.next = new FruitNode(key, value);
            }
        }
    }

}
