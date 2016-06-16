package com.vmr.vmrdemo.HomeFragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.vmr.vmrdemo.FileFolderListAdapter;
import com.vmr.vmrdemo.R;

import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FragmentMyRecords extends Fragment {

    private FileFolderListAdapter mAdapter;
    private List<File> mFileList;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_my_records, container, false);

        ListView listView = (ListView) view.findViewById(R.id.lvMyRecords);

        mFileList = getFileList();
        mAdapter = new FileFolderListAdapter(getActivity(), mFileList);

        listView.setAdapter(mAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String text = mFileList.get(i).getName();
                Toast.makeText(getActivity(), text + " clicked.", Toast.LENGTH_SHORT).show();
            }
        });
        return view;
    }

    public interface OnFragmentInteractionListener {
        void onFragmentInteraction(Uri uri);
    }

    private List<File> getFileList(){
        File f = new File(Environment.getRootDirectory().getPath());
        ArrayList<File> inFiles = new ArrayList<>();
        File[] files = f.listFiles();
        Collections.addAll(inFiles, files);
        return inFiles;
    }

}
