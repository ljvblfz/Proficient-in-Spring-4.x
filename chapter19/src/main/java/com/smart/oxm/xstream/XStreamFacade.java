package com.smart.oxm.xstream;

import java.io.File;
import java.util.List;

import com.thoughtworks.xstream.XStream;
import com.thoughtworks.xstream.io.json.JettisonMappedXmlDriver;
import com.thoughtworks.xstream.io.json.JsonHierarchicalStreamDriver;
import com.thoughtworks.xstream.io.xml.DomDriver;
import com.thoughtworks.xstream.io.xml.XppDriver;
import com.thoughtworks.xstream.persistence.FilePersistenceStrategy;
import com.thoughtworks.xstream.persistence.PersistenceStrategy;
import com.thoughtworks.xstream.persistence.XmlArrayList;

public class XStreamFacade {
	private static XStream xstream;
	public static final String JAXP_DOM_XML = "JAXP DOM";
	public static final String XPP3_XML_PARSER = "XPP3";
	public static final String STAX_JSON_PARSER = "Jettison StAX";
	public static final String WRITER_JSON_PARSER = "Only Writer JSON";
	
	public synchronized static XStream getXStream(String driver) {
		if (JAXP_DOM_XML.equals(driver)) {
			xstream = new XStream(new DomDriver());
			xstream.autodetectAnnotations(true);
		} else if (XPP3_XML_PARSER.equals(driver)) {
			xstream = new XStream(new XppDriver());
			xstream.autodetectAnnotations(true);
		} else if (STAX_JSON_PARSER.equals(driver)) {
			xstream = new XStream(new JettisonMappedXmlDriver());
			xstream.setMode(XStream.NO_REFERENCES);
		} else if (WRITER_JSON_PARSER.equals(driver)) {
			xstream = new XStream(new JsonHierarchicalStreamDriver());
			xstream.setMode(XStream.NO_REFERENCES);
		} else {
			xstream = new XStream(new DomDriver());
		}

		return xstream;
	}

	@SuppressWarnings("unchecked")
	public void persist(String dir, List objects) {
		PersistenceStrategy strategy = new FilePersistenceStrategy(new File(
				System.getProperty("user.home"), dir));

		List<?> list = new XmlArrayList(strategy);

		list.addAll(objects);
	}

}
