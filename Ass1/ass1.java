import java.rmi.*;

public class AddClient{
    public static void main(String[] args) {
        try{
            AddServerIntf stub=(AddServerIntf) Naming.lookup("rmi://"+args[0]+"/AddServer");
            double a=Double.parseDouble(args[1]);
            double b=Double.parseDouble(args[2]);
            System.out.println("Sum: "+stub.add(a,b));
        }
        catch(Exception e)
        {
            System.out.println("Error: "+e);
        }
    }
}


/////////////////////////////

import java.rmi.*;

public class AddServer{
    public static void main(String[] args) {
        try{
            Naming.rebind("AddServer", new AddServerImpl());
            System.out.println("Server is getting ready....");
        }
        catch(Exception e)
        {
            System.out.println("Error: "+e);
        }
    }
}

///////////////////


import java.rmi.*;
import java.rmi.server.*;

public class AddServerImpl extends UnicastRemoteObject implements AddServerIntf{
    AddServerImpl() throws RemoteException{
        super();
    }

    public double add(double a,double b)
    {
        return a+b;
    }
}

//////////////

import java.rmi.*;

public interface AddServerIntf extends Remote{
    double add(double d1,double d2) throws RemoteException;
}
