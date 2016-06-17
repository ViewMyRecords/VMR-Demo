package com.vmr.vmrdemo;/*
 * Created by abhijit on 6/15/16.
 */

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.Date;
import java.util.List;

public class FileFolderListAdapter extends ArrayAdapter<File> {

    private Context context;
    private int viewResourceId;
    private List<File>items;

    public FileFolderListAdapter(Context context, List<File> fileFoldersList) {
        super(context, R.layout.file_folder_layout , fileFoldersList);
        this.context = context;
        this.viewResourceId = R.layout.file_folder_layout;
        this.items = fileFoldersList;
    }

    public File getItem(int i) {
        return items.get(i);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View view ;

        if (convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = layoutInflater.inflate(viewResourceId, parent, false);
        } else {
            view = convertView;
        }

        /* create a new view of my layout and inflate it in the row */
        final File fileFolder = items.get(position);

        if (fileFolder != null) {
            TextView fileName = (TextView) view.findViewById(R.id.tvFileName);
            TextView fileSize = (TextView) view.findViewById(R.id.tvFileSize);
            TextView fileTimestamp = (TextView) view.findViewById(R.id.tvTimeStamp);
            ImageView fileImage = (ImageView) view.findViewById(R.id.ivFileIcon);

            if(fileName!=null) {
                fileName.setText(fileFolder.getName());
            }

            if(fileSize!=null) {
                if (fileFolder.isDirectory()) {
                    File[] files = fileFolder.listFiles();
                    int numOfFiles = 0;
                    if (files != null) {
                        numOfFiles = files.length;
                    }
                    String temp = numOfFiles + " Items";
                    fileSize.setText(temp);
                } else {
                    String value = null;
                    long size = fileFolder.length() / 1024;
                    if (size >= 1024)
                        value = size / 1024 + " Mb";
                    else
                        value = size + " Kb";
                    fileSize.setText(value);
                }
            }

            if(fileTimestamp!=null) {
                Date lastModified = new Date(fileFolder.lastModified());
                fileTimestamp.setText(lastModified.toString());
            }

            if(fileImage != null){
                if (! fileFolder.isDirectory()) {
                    fileImage.setImageResource(R.drawable.ic_file);
                } else {
                    fileImage.setImageResource(R.drawable.ic_folder_2);
                }
            }
        }
        return view;
    }
}
