package com.vmr.vmrdemo.HomeFragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.vmr.vmrdemo.FileFolderListAdapter;
import com.vmr.vmrdemo.HomeActivity;
import com.vmr.vmrdemo.R;

import java.io.File;
import java.io.FileFilter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FragmentMyRecords extends Fragment {

    private FileFolderListAdapter mAdapter;
    private List<File> mFileList;
    private OnFragmentInteractionListener mListener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
//        mListener.onFragmentInteraction("My Records");
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

        final FloatingActionButton fab = (FloatingActionButton) view.findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Add new item action", Snackbar.LENGTH_LONG).show();
            }
        });

        listView.setOnScrollListener(new ListView.OnScrollListener(){

            @Override
            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                    fab.hide();
                } else {
                    fab.show();
                }
            }

            @Override
            public void onScroll(AbsListView absListView, int i, int i1, int i2) {

            }
        });

        if (mListener != null) {
            mListener.onFragmentInteraction("My Records");
        }

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    private List<File> getFileList(){
        File f = new File(Environment.getExternalStorageDirectory().getPath());
        ArrayList<File> inFiles = new ArrayList<>();

        File[] files = f.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return !file.isDirectory();
            }
        });

        File[] dirs = f.listFiles(new FileFilter() {
            @Override
            public boolean accept(File file) {
                return file.isDirectory();
            }
        });

        Collections.addAll(inFiles, dirs);
        Collections.sort(inFiles);
        Collections.addAll(inFiles, files);

        return inFiles;
    }

    public interface OnFragmentInteractionListener {
        public void onFragmentInteraction(String title);
    }
}
