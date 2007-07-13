package org.apache.maven.plugin.assembly.archive.archiver;

import org.codehaus.plexus.archiver.ArchivedFileSet;
import org.codehaus.plexus.components.io.fileselectors.FileSelector;

import java.io.File;

public class PrefixedArchivedFileSet
    implements ArchivedFileSet
{

    private final String rootPrefix;
    private final ArchivedFileSet fileSet;

    public PrefixedArchivedFileSet( ArchivedFileSet fileSet, String rootPrefix )
    {
        this.fileSet = fileSet;

        if ( ! rootPrefix.endsWith( "/" ) )
        {
            this.rootPrefix = rootPrefix + "/";
        }
        else
        {
            this.rootPrefix = rootPrefix;
        }
    }

    public File getArchive()
    {
        return fileSet.getArchive();
    }

    public String[] getExcludes()
    {
        return fileSet.getExcludes();
    }

    public FileSelector[] getFileSelectors()
    {
        return fileSet.getFileSelectors();
    }

    public String[] getIncludes()
    {
        return fileSet.getIncludes();
    }

    public String getPrefix()
    {
        String prefix = fileSet.getPrefix();
        if ( prefix.startsWith( "/" ) )
        {
            if ( prefix.length() > 1 )
            {
                prefix = prefix.substring( 1 );
            }
            else
            {
                prefix = "";
            }
        }

        return rootPrefix + prefix;
    }

    public boolean isCaseSensitive()
    {
        return fileSet.isCaseSensitive();
    }

    public boolean isIncludingEmptyDirectories()
    {
        return fileSet.isIncludingEmptyDirectories();
    }

    public boolean isUsingDefaultExcludes()
    {
        return fileSet.isUsingDefaultExcludes();
    }

}