package hospital.data;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.Marshaller;
import jakarta.xml.bind.Unmarshaller;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class XmlPersister {
    private String path;
    private static XmlPersister theInstance;

    public static XmlPersister theInstance() {
        if (theInstance == null) {
            theInstance = new XmlPersister("listas.xml");
        }
        return theInstance;
    }
    private XmlPersister(String path) {
        this.path = path;
    }

    public Listas load() throws Exception{
        JAXBContext jaxbContext = JAXBContext.newInstance(Listas.class);
        FileInputStream is = new FileInputStream(path);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        Listas result = (Listas) unmarshaller.unmarshal(is);
        is.close();
        return result;
    }

    public void store(Listas listas) throws Exception{
        JAXBContext jaxbContext = JAXBContext.newInstance(Listas.class);
        FileOutputStream os = new FileOutputStream(path);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.marshal(listas, os);
        os.flush();
        os.close();
    }
}
